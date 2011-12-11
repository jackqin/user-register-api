package com.colorcc.user.register.marshal.marshaller;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.register.bean.UserBean;
import com.colorcc.user.register.marshal.Marshaller;

public class UserBeanMarshaller implements Marshaller {
	
	private static final Logger logger = LoggerFactory.getLogger(UserBeanMarshaller.class);

	public String marshal(Object t) throws JSONException {
		try {
			UserBean userBean = (UserBean)t;
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", userBean.getId());
			jsonObject.put("email", userBean.getEmail());
			jsonObject.put("registerDate", userBean.getRegisterDate());
			jsonObject.put("username", userBean.getUsername());
			if (logger.isDebugEnabled()) {
				logger.debug(jsonObject.toString());
			}
			return jsonObject.toString();
		} catch (ClassCastException e) {
			e.printStackTrace();
			return "";
		}
	}

}
