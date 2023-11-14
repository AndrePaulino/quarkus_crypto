package com.apaulino.resource;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.apaulino.model.User;

@Path("/users")
public class UserResource {

	@POST
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(User user) {
		User.insert(user);
	}

}
