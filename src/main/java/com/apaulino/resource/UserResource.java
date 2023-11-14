package com.apaulino.resource;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.apaulino.model.User;

@Path("/users")
public class UserResource {

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(User user) {
		User.persist(user);
	}

}
