package com.apaulino.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Setter;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	private Double preco;

	@Setter
	private String tipo;

	@Setter
	private LocalDate data;

	@Setter
	private String status;

	@Setter
	private Long userId;

}