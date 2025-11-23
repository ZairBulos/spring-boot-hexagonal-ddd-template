package com.zair.infrastructure.adapters.out.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "entities")
@NoArgsConstructor @AllArgsConstructor @Getter
public class PersistenceEntity {

    @Id
    private UUID id;
}
