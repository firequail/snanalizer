package snanalizer.util;

import flex.messaging.messages.Message;
import flex.messaging.services.remoting.adapters.JavaAdapter;


public class SNAJavaAdapter extends JavaAdapter {
	
	@Override
	public Object invoke(Message message) {
		
		Object result = super.invoke(message);
		
		if(result == null) {
			return null;
		}
		
		Object serialized = new SNAFlexSerializer().serialize(result);
		return serialized;
	}

	
}
