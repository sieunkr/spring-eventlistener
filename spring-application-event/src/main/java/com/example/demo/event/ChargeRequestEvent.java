package com.example.demo.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ChargeRequestEvent extends ApplicationEvent {

    private long orderId;

    public ChargeRequestEvent(Object source, long orderId) {
        super(source);
        this.orderId = orderId;
    }
}
