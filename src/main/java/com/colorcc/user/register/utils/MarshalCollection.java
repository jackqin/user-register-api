package com.colorcc.user.register.utils;

import java.util.HashMap;
import java.util.Map;

import com.colorcc.user.register.marshal.Marshaller;
import com.colorcc.user.register.marshal.marshaller.DefaultMarshaller;
import com.colorcc.user.register.marshal.marshaller.UserBeanMarshaller;

public class MarshalCollection {

	private static MarshalCollection mc;
	private static Map<String, Marshaller> marshallerMap = new HashMap<String, Marshaller>();

	private MarshalCollection() {

	}
	
	static {
		marshallerMap.put("default", new DefaultMarshaller());
		marshallerMap.put("userBean", new UserBeanMarshaller());
	}

	public static MarshalCollection getInstance() {
		if (mc == null) {
			mc = new MarshalCollection();
		}
		return mc;
	}
	
	public Map<String, Marshaller> getMarshaller() {
		return marshallerMap;
	}
	
	public void addMarshaller(String key, Marshaller value) {
		marshallerMap.put(key, value);
	}
	
	public void addUnmarshaller() {
		
	}

}
