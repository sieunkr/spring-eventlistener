package com.example.demo.order;

import com.example.demo.event.ChargeRequestEvent;
import com.example.demo.exception.ChargeRuntimeException;
import com.example.demo.exception.ExceptionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher publisher;

    public void pay(long orderId) {

        Order order = orderRepository.findById(orderId).orElseGet(() -> {
            throw new ChargeRuntimeException();
        });

        //방법1
        //order.pay(publisher);

        //방법2
        try {
            order.startedPay();
            publisher.publishEvent(new ChargeRequestEvent(orderId));
            order.completedPay();
        } catch (ChargeRuntimeException ex) {
            log.error(ExceptionMessage.CHARGE_ERROR.name());    //TODO: message get
        }
    }
}