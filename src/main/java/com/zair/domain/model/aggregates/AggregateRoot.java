package com.zair.domain.model.aggregates;

import com.zair.domain.events.DomainEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot {
    private final List<DomainEvent> events = new ArrayList<>();

    protected void registerEvent(DomainEvent event) {
        events.add(event);
    }

    public List<DomainEvent> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public void clearEvents() {
        events.clear();
    }
}
