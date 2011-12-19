package com.colorcc.user.register.marshal.marshaller;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

import com.colorcc.user.register.bean.BeanList;
import com.colorcc.user.register.marshal.Marshaller;

public class BeanListMarshaller<T>  implements Marshaller {

	public String marshal(Object t) throws JSONException {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ : generic");
		
		@SuppressWarnings("unchecked")
		BeanList<T> beanList = (BeanList<T>) t;
		List<T> genericList = beanList.getBeanList();
		if (genericList.size() > 0) {
			System.out.println("Will do in feature");
		}
		
		
		Object t1 = t;
		
		System.out.println(t1.getClass().getName());
		
		return null;
	}

}
