package com.zair.application.ports.out;

import com.zair.domain.events.DomainEvent;

public interface EventPublisherPort {
    void publish(DomainEvent event);
}
