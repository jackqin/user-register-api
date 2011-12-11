package com.colorcc.user.register.marshal.marshaller;

import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.register.marshal.Marshaller;

public class DefaultMarshaller implements Marshaller {

	private static final Logger logger = LoggerFactory.getLogger(DefaultMarshaller.class);

	public String marshal(Object t) throws JSONException {
		logger.debug("Default marshaller!");
		return "";
	}

}
