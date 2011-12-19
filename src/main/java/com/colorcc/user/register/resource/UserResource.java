package com.colorcc.user.register.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colorcc.user.register.bean.BeanList;
import com.colorcc.user.register.bean.UserBean;
import com.colorcc.user.register.service.UserService;

@Path("/user")
@Component
@Scope("singleton")
public class UserResource {

	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

	public UserResource() {
		if (logger.isDebugEnabled()) {
			logger.debug("Resource constructor!");
		}
	}

	@Autowired
	UserService userServiceImpl;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		Long startRow = 0L;
		int fetchRows = 5;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ start");
		
		BeanList<UserBean> beanList = new BeanList<UserBean>();
		beanList.setBeanList(userServiceImpl.getUserList(startRow, fetchRows));
		
		return Response.ok().entity(beanList).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("Get user by id: " + id);
		}
		UserBean userBean = userServiceImpl.getUser(Long.valueOf(id));

		return Response.ok().entity(userBean).build();
	}

}
