package com.example.demo.alarm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlarmService {

    public void send(String message) {
        log.info(message);
    }
}
