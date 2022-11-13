package org.multilens.msvc.optica.gestionproductos.repository;

import org.multilens.msvc.optica.gestionproductos.entity.CategoriaEntity;
import org.multilens.msvc.optica.gestionproductos.entity.SubCategoriaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubCategoriaRepository   extends JpaRepository<SubCategoriaEntity, UUID> {

    @Query("select c from SubCategoriaEntity c")
    Page<SubCategoriaEntity> findAllPage(Pageable pageable);

    @Query("select c from SubCategoriaEntity c where UPPER(c.nombre) like UPPER(:nombre) ORDER BY c.nombre")
    Optional<SubCategoriaEntity> findByLikeNombre(@Param("nombre") String nombre);

    @Query("select c from SubCategoriaEntity c where c.subCategoriaTitulos.categoria.id = :categoria")
    List<SubCategoriaEntity> findByCategoria(@Param("categoria") UUID categoria);

}
