package com.example.demo.order;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PAYMENT_WAITING("결제 대기 중"),
    PREPARING("상품 준비 중"),
    DELIVERING("배송 중"),
    DELIVERY_COMPLETED("배송 완료"),
    CANCELED("상품 취소");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
}