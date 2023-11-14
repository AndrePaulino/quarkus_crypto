package com.apaulino.repository;

import javax.enterprise.context.ApplicationScoped;

import com.apaulino.model.Order;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {
}
