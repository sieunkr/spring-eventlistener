package com.example.demo.order;

import com.example.demo.event.ChargeRequestEvent;
import com.example.demo.exception.ChargeRuntimeException;
import com.example.demo.exception.ExceptionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
public class Order {

    private long orderId;
    private OrderStatus status;

    public Order(long orderId) {
        this.orderId = orderId;
    }


    void pay(ApplicationEventPublisher publisher) {

        verifyPayable();
        startedPay();

        try {
            publisher.publishEvent(new ChargeRequestEvent(this, orderId));
            completedPay();
        } catch (ChargeRuntimeException ex) {
            log.error(ExceptionMessage.CHARGE_ERROR.name());    //TODO: message get
        }
    }

    void startedPay() {
        this.status = OrderStatus.PAYMENT_WAITING;
    }

    void completedPay() {
        this.status = OrderStatus.PREPARING;
    }

    private void verifyPayable() {
        //TODO: 유효성 체크

    }
}