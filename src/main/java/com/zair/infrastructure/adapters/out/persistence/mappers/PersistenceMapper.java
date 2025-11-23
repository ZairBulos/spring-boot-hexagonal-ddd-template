package com.zair.infrastructure.adapters.out.persistence.mappers;

import com.zair.domain.model.entities.DomainEntity;
import com.zair.domain.model.valueobjects.EntityId;
import com.zair.infrastructure.adapters.out.persistence.entities.PersistenceEntity;
import org.springframework.stereotype.Component;

@Component
public class PersistenceMapper {

    public PersistenceEntity toPersistenceEntity(DomainEntity domainEntity) {
        return new PersistenceEntity(domainEntity.getId().value());
    }

    public DomainEntity toDomainEntity(PersistenceEntity persistenceEntity) {
        return new DomainEntity(new EntityId(persistenceEntity.getId())) {};
    }
}
