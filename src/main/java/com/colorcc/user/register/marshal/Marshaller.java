package com.colorcc.user.register.marshal;

import org.codehaus.jettison.json.JSONException;

public interface Marshaller {
	
	public String marshal(Object t) throws JSONException;

}
