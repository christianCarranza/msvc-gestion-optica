package org.multilens.msvc.optica.gestionproductos.repository;

import org.multilens.msvc.optica.gestionproductos.entity.DisputaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DisputaRepository  extends JpaRepository<DisputaEntity, UUID> {

    @Query("select d from DisputaEntity d where UPPER(d.comentario) like UPPER(:comentario) ORDER BY d.comentario")
    Optional<DisputaEntity> findByLikeComentario(@Param("comentario") String comentario);

    @Query("select d from DisputaEntity d where d.estado=1")
    Page<DisputaEntity> findAllPage(Pageable pageable);

}
