package com.zair.domain.model.aggregates;

import com.zair.domain.events.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot {
    private final List<DomainEvent> events = new ArrayList<>();

    protected void addEvent(DomainEvent event) {
        events.add(event);
    }

    public List<DomainEvent> pullEvents() {
        List<DomainEvent> domainEvents = new ArrayList<>(events);
        events.clear();
        return domainEvents;
    }
}
