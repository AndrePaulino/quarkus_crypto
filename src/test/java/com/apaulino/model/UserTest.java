package com.apaulino.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserTest {

	@Test
	public void testarSeFindByIdOptionalDevolveUsuarioCorreto() {
		PanacheMock.mock(User.class);

		User u = new User();
		Optional<PanacheEntityBase> user = Optional.of(u);

		when(User.findByIdOptional(40)).thenReturn(user);

		assertSame(u, User.findByIdOptional(40).get());
	}

}
