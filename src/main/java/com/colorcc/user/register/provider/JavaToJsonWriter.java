package com.colorcc.user.register.provider;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.common.annotation.AnnotationHelper;
import com.colorcc.user.register.marshal.Marshaller;
import com.colorcc.user.register.utils.MarshalCollection;

public abstract class JavaToJsonWriter<T> implements MessageBodyWriter<T> {

	private static final Logger logger = LoggerFactory.getLogger(JavaToJsonWriter.class);

	private String jsonString;
	MarshalCollection marshalCollection = MarshalCollection.getInstance();

	public long getSize(T t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// Get t's annotation, if it was annotated by ColorccMarshalAnnotation, then will do marshal work
		String colorccMarshalAnnotationValue = AnnotationHelper.getColorccMarshalAnnotationValue(t.getClass());

		if (colorccMarshalAnnotationValue != null) {
			Marshaller marshaller = marshalCollection.getMarshaller().get(colorccMarshalAnnotationValue);
			if (marshaller != null) {
				try {
					jsonString = marshaller.marshal(t);
				} catch (JSONException e) {
					jsonString = "";
					e.printStackTrace();
				}
			} else {
				jsonString = "";
			}
			if (logger.isDebugEnabled()) {
				logger.debug(jsonString);
			}
			return jsonString.length();

		} else {
			jsonString = "";
		}
		return -1;
	}

	@Override
	public void writeTo(T t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException,
			WebApplicationException {
		if (jsonString != null) {
			entityStream.write(jsonString.getBytes());
		} else {
			entityStream.write("{}".getBytes());
		}

	}

}
