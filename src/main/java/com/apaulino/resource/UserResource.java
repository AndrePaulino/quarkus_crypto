package com.apaulino.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> list() {
		return User.listAll();
	}
}
