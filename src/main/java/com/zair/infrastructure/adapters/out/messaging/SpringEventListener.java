package com.zair.infrastructure.adapters.out.messaging;

import com.zair.domain.events.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
// import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringEventListener {

    // @Async
    @EventListener
    public void onDomainEvent(DomainEvent event) {
        log.info("Domain event received: {}", event);
    }
}
