package com.apaulino.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import com.apaulino.model.Order;
import com.apaulino.model.User;
import com.apaulino.repository.OrderRepository;

@ApplicationScoped
public class OrderService {

	@Inject
	OrderRepository orderRepository;

	public void insert(SecurityContext securityContext, Order order) {
		Optional<User> optionalUser = User.findByIdOptional(order.getUserId());
		User user = optionalUser.orElseThrow();
		if (!user.getUsername().equals(securityContext.getUserPrincipal().getName())) {
			throw new RuntimeException("O usuário logado é diferente do userId");
		}

		order.setData(LocalDate.now());
		order.setStatus("ENVIADA");
		orderRepository.persist(order);
	}
}
