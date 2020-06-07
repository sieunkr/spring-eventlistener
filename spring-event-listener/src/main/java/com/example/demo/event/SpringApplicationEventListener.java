package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringApplicationEventListener {

    @EventListener
    public void handler(ApplicationStartedEvent event) {
        log.info("ApplicationStartedEvent");
    }

}
