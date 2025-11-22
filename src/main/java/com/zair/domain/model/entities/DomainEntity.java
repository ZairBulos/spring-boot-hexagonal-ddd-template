package com.zair.domain.model.entities;

import com.zair.domain.model.valueobjects.EntityId;

public abstract class DomainEntity {
    private final EntityId id;

    public DomainEntity() {
        this.id = EntityId.generate();
    }

    public EntityId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DomainEntity{" +
                "id=" + id +
                '}';
    }
}
