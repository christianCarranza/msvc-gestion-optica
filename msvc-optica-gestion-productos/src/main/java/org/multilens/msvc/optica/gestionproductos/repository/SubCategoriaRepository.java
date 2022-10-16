package org.multilens.msvc.optica.gestionproductos.repository;

import org.multilens.msvc.optica.gestionproductos.entity.CategoriaEntity;
import org.multilens.msvc.optica.gestionproductos.entity.SubCategoriaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubCategoriaRepository   extends JpaRepository<SubCategoriaEntity, UUID> {

    @Query("select c from SubCategoriaEntity c")
    Page<SubCategoriaEntity> findAllPage(Pageable pageable);

}
