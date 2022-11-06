package org.multilens.msvc.optica.gestionproductos.repository;

import org.multilens.msvc.optica.gestionproductos.entity.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductoRepository   extends JpaRepository<ProductoEntity, UUID> {

    @Query("select c from ProductoEntity c where UPPER(c.nombre) like UPPER(:nombre) ORDER BY c.nombre")
    Optional<ProductoEntity> findByLikeNombre(@Param("nombre") String nombre);

    @Query("select p from ProductoEntity p ORDER BY p.nombre")
    Page<ProductoEntity> findAllPage(Pageable pageable);

    @Query("select p from ProductoEntity p where p.estado=1 ORDER BY p.nombre")
    Page<ProductoEntity> findAllPageActive(Pageable pageable);

    @Query("select p from ProductoEntity p where p.id = :id and  p.estado=1 ORDER BY p.nombre")
    ProductoEntity findByIdActive(UUID id);
}