package snanalizer.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

import org.hibernate.collection.AbstractPersistentCollection;
import org.springframework.beans.BeanWrapperImpl;

import snanalizer.domain.DomainEntity;
import flex.messaging.io.amf.ASObject;

public class SNAFlexSerializer {

	/** 
	 * Cache para resolver problemas de referencia ciclica
	 */
	private Map<Object, Object> cache = new HashMap<Object, Object>();

	@SuppressWarnings("unchecked")
	public Object serialize(Object object) {
		if (object == null) {
			return null;
		}

		if (isPrimitive(object)) {
			return object;
		}

		if (object instanceof Collection) {
			return serializeCollection((Collection) object);
		}

		return serializeObject(object);
	}

	private boolean isPrimitive(Object object) {
		return object instanceof String || object instanceof Integer
				|| object instanceof Boolean;
	}

	@SuppressWarnings("unchecked")
	private Object serializeObject(Object object) {
		try {
			if (cache.containsKey(object)) {
				return cache.get(object);
			}

			ASObject asResult = new ASObject();
			cache.put(object, asResult);
			
			PropertyDescriptor[] properties = new BeanWrapperImpl(object)
					.getPropertyDescriptors();

			for (PropertyDescriptor property : properties) {
				Method readMethod = property.getReadMethod();
				if (isConvertable(readMethod)) {
					Object value = readMethod.invoke(object, new Object[0]);
					asResult.put(property.getName(), serialize(value));
				}
			}

			asResult.setType(object.getClass().getName());
			return asResult;

		} catch (Exception e) {
			System.out
					.println("Error during conversion. Object won't be converted: "
							+ e.getMessage());
		}

		return null;
	}

	private boolean isConvertable(Method readMethod) {
		return readMethod != null
				&& DomainEntity.class.isAssignableFrom(readMethod
						.getDeclaringClass())
				&& !readMethod.isAnnotationPresent(Transient.class);
	}

	@SuppressWarnings("unchecked")
	private Object serializeCollection(Collection collection) {
		Collection result = new ArrayList();
		if (!(isLazy(collection))) {
			for (Object item : collection) {
				result.add(this.serialize(item));
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private boolean isLazy(Collection collection) {
		if (!(collection instanceof AbstractPersistentCollection)) {
			return false;
		} else {
			AbstractPersistentCollection col = (AbstractPersistentCollection) collection;
			return !col.wasInitialized();
		}
	}

}
