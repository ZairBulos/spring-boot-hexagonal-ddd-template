package com.zair.infrastructure.adapters.out.persistence.repositories;

import com.zair.infrastructure.adapters.out.persistence.entities.PersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersistenceRepository extends JpaRepository<PersistenceEntity, UUID> {}
