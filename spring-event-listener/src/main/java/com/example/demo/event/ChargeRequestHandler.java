package com.example.demo.event;

import com.example.demo.alarm.AlarmService;
import com.example.demo.charge.ChargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChargeRequestHandler {

    private final ChargeService chargeService;
    private final AlarmService alarmService;

    @Order(1)
    @EventListener
    public void update(ChargeRequestEvent event) {
        chargeService.charge(event.getOrderId());
    }

    @Async
    @Order(2)
    @EventListener
    public void alarm(ChargeRequestEvent event) {
        alarmService.send(event.getOrderId() + " 결제 완료 메시지");
    }
}