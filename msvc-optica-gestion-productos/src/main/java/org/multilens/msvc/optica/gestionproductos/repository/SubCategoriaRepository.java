package org.multilens.msvc.optica.gestionproductos.repository;

import org.multilens.msvc.optica.gestionproductos.entity.SubCategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubCategoriaRepository   extends JpaRepository<SubCategoriaEntity, UUID> {
}
