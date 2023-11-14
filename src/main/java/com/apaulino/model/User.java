package com.apaulino.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import lombok.Getter;
import lombok.Setter;

@Entity
@UserDefinition
@Table(name = "Usuario")
public class User extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	private String nome;

	@Setter
	private String cpf;

	@Getter
	@Setter
	@Username
	private String username;

	@Getter
	@Setter
	@Password
	private String password;

	@Getter
	@Setter
	@Roles
	private String role;

	public static void insert(User user) {
		user.password = BcryptUtil.bcryptHash(user.password);
		user.role = usernameValidation(user.username);
		user.persist();
	}

	private static String usernameValidation(String username) {
		return username.equals("apaulino") ? "admin" : "user";
	}
}
