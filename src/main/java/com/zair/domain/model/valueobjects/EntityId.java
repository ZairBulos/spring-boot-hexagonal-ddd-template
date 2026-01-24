package com.zair.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record EntityId(UUID value) {

    public EntityId {
        Objects.requireNonNull(value, "EntityId cannot be null");
    }

    public static EntityId generate() {
        return new EntityId(UUID.randomUUID());
    }

    public static EntityId fromString(String value) {
        Objects.requireNonNull(value, "EntityId string cannot be null");
        return new EntityId(UUID.fromString(value));
    }

    public String asString() {
        return value.toString();
    }
}
