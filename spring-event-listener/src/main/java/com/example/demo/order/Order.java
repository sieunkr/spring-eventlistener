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


    public void pay(ApplicationEventPublisher publisher) {

        verifyPayable();
        startedPay();

        try {
            publisher.publishEvent(new ChargeRequestEvent(orderId));
            completedPay();
        } catch (ChargeRuntimeException ex) {
            log.error(ExceptionMessage.CHARGE_ERROR.name());    //TODO: message get
        }
    }

    public void startedPay() {
        this.status = OrderStatus.PAYMENT_WAITING;
    }

    public void completedPay() {
        this.status = OrderStatus.PREPARING;
    }

    private boolean verifyPayable() {
        //TODO: 유효성 체크
        return true;
    }
}