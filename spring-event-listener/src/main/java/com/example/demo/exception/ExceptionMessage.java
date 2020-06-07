package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    CHARGE_ERROR("상품 결제 중 에러가 발생했습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
