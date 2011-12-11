package com.colorcc.user.register.provider.writer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.register.bean.UserBean;
import com.colorcc.user.register.provider.JavaToJsonWriter;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class UserBeanWriter extends JavaToJsonWriter<UserBean> {
	
	private static final Logger logger = LoggerFactory.getLogger(UserBeanWriter.class);
	
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		if (logger.isDebugEnabled()) {
			logger.debug("Do Write Action!");
		}
		return UserBean.class.isAssignableFrom(type);
	}

}
