package com.apaulino.resource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.apaulino.model.Order;
import com.apaulino.service.OrderService;

@Path("/orders")
public class OrderResource {

	@Inject
	OrderService orderService;

	@POST
	@Transactional
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(@Context SecurityContext securityContext, Order order) {
		orderService.insert(securityContext, order);
	}

}
