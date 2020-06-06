package com.example.demo.event;

import com.example.demo.charge.ChargeService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ChargeRequestHandler implements ApplicationListener<ChargeRequestEvent> {

    private final ChargeService chargeService;

    public ChargeRequestHandler(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @Override
    public void onApplicationEvent(ChargeRequestEvent event) {
        chargeService.charge(event.getOrderId());
    }
}
