package com.example.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Order {

    private long orderId;
    private OrderStatus status;

    public void pay(ChargeService chargeService) {

        startedPay();

        try {
            chargeService.charge(orderId);
            completedPay();
        } catch (ChargeRuntimeException ex) {
            log.error("상품 결제 요청 중 에러가 발생하였습니다.");
        }
    }

    private void startedPay() {
        this.status = OrderStatus.PAYMENT_WAITING;
    }

    private void completedPay() {
        this.status = OrderStatus.PREPARING;
    }
}