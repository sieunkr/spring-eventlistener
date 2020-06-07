package com.example.demo.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ChargeRequestEvent {

    private long orderId;

    public ChargeRequestEvent(long orderId) {
        this.orderId = orderId;
    }
}
