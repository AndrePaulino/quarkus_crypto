package com.apaulino.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Ordem")
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

	@Getter
	@Setter
	@Column(name = "user_id")
	private Long userId;

}