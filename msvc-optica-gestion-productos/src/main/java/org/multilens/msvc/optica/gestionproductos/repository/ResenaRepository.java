package org.multilens.msvc.optica.gestionproductos.repository;

import org.multilens.msvc.optica.gestionproductos.entity.ResenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResenaRepository extends JpaRepository<ResenaEntity, UUID> {
}
