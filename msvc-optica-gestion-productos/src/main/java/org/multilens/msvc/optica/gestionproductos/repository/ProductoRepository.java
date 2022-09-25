package org.multilens.msvc.optica.gestionproductos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.multilens.msvc.optica.gestionproductos.entity.ProductoEntity;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    /*@Query("select p from ProductoEntity p where UPPER(p.nombre) like UPPER(:nombre) and p.estado='1'")
    List<ProductoEntity> findByLikeNombre(@Param("nombre") String nombre);

    @Modifying
    @Query("update ProductoEntity set stock=stock - :cantidad where id=:id") // JPQL
    void updataStock(@Param("id") Long id, @Param("cantidad") Integer stock);

    @Query("select p from ProductoEntity p where p.estado='1'")
    Page<ProductoEntity> findAllCustom(Pageable pageable);*/


}
