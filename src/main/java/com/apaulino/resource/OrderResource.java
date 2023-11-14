package com.apaulino.resource;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.apaulino.model.Order;
import com.apaulino.repository.OrderRepository;

@Path("/orders")
public class OrderResource {

	@Inject
	OrderRepository orderRepository;

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Order order) {
		order.setData(LocalDate.now());
		order.setStatus("ENVIADA");
		orderRepository.persist(order);
	}

}
