package com.example.demo.order;

import com.example.demo.charge.ChargeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @SpyBean
    private ChargeService chargeService;

    @Test
    void payTest() {

        //given
        long orderId = 7;
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(new Order(orderId)));

        //when
        orderService.pay(orderId);

        //then
        verify(chargeService, times(1)).charge(orderId);

    }
}