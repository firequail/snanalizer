package snanalizer.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Transient;

import org.hibernate.collection.AbstractPersistentCollection;
import org.springframework.beans.BeanWrapperImpl;

import snanalizer.domain.DomainEntity;

import flex.messaging.io.amf.ASObject;
import flex.messaging.messages.Message;
import flex.messaging.services.remoting.adapters.JavaAdapter;


public class SNAJavaAdapter extends JavaAdapter {
	
	@Override
	public Object invoke(Message message) {
		
		Object result = super.invoke(message);
		
		if(result == null) {
			return null;
		}
		
		Object serialized = serialize(result);
		return serialized;
	}

	@SuppressWarnings("unchecked")
	private Object serialize(Object object) {
		if(object == null) {
			return null;
		}
		
		if(object instanceof Collection) {
			return serializeCollection((Collection) object);
		}
		
		if(isPrimitive(object)) {
			return object;
		}
		
		return serializeObject(object);
	}

	private boolean isPrimitive(Object object) {
		return object instanceof String || object instanceof Integer || object instanceof Boolean;
	}
	
	@SuppressWarnings("unchecked")
	private Object serializeObject(Object object) {
		try{
			ASObject asResult = new ASObject();
			PropertyDescriptor[] properties = new BeanWrapperImpl(object).getPropertyDescriptors();
			
			for (PropertyDescriptor property : properties) {
				Method readMethod = property.getReadMethod();
				if(isConvertable(readMethod)) {
					Object value = readMethod.invoke(object, new Object[0]);
					asResult.put(property.getName(), serialize(value));
				}
			}
			
			asResult.setType(object.getClass().getName());
			return asResult;
			
		}catch (Exception e){
			System.out.println("Error during conversion. Object won't be converted: " + e.getMessage());
		}

		return null;
	}

	private boolean isConvertable(Method readMethod) {
		return readMethod != null && DomainEntity.class.isAssignableFrom(readMethod.getDeclaringClass())
		&& readMethod.getName().startsWith("get") && !readMethod.isAnnotationPresent(Transient.class);
	}
	
	@SuppressWarnings("unchecked")
	private Object serializeCollection(Collection collection){
		//TODO manejar referencias ciclicas (no creo que se de un caso)
		Collection result = new ArrayList();
		if(!(collection instanceof AbstractPersistentCollection)) {
			for (Object item : collection){
				result.add(this.serialize(item));
			}
		}
		return result;
	}
}
