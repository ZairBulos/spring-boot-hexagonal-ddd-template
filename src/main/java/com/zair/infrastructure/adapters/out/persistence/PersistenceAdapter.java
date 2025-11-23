package com.zair.infrastructure.adapters.out.persistence;

import com.zair.application.ports.out.OutputPort;
import com.zair.infrastructure.adapters.out.persistence.mappers.PersistenceMapper;
import com.zair.infrastructure.adapters.out.persistence.repositories.PersistenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistenceAdapter implements OutputPort {
    private final PersistenceRepository repository;
    private final PersistenceMapper mapper;

    @Override
    public void action() {
        System.out.println("Perform a persistence action");
    }
}
