package com.example.demo.event;

import com.example.demo.charge.ChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChargeRequestHandler implements ApplicationListener<ChargeRequestEvent> {

    private final ChargeService chargeService;

    public ChargeRequestHandler(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @Override
    public void onApplicationEvent(ChargeRequestEvent event) {
        log.info(String.valueOf(event.getTimestamp()));
        chargeService.charge(event.getOrderId());
    }
}
