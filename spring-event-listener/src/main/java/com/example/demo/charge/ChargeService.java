package com.example.demo.charge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChargeService {

    public void charge(long orderId) {


        //상품 결제 비즈니스 로직
        log.info("상품 결제 : " + orderId);

        //throw new ChargeRuntimeException();

    }
}