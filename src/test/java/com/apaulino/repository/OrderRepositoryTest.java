package com.apaulino.repository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;

import com.apaulino.model.Order;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class OrderRepositoryTest {

    @InjectMock
    OrderRepository orderRepository;

    @Test
    public void testarSeListAllRetornaOrdensCorretas() {
        Order primeiraOrder = new Order();
        Order segundaOrder = new Order();
        List<Order> orders = new ArrayList<>();

        orders.add(primeiraOrder);
        orders.add(segundaOrder);

        when(orderRepository.listAll()).thenReturn(orders);

        assertSame(segundaOrder, orderRepository.listAll().get(1));
    }

}
