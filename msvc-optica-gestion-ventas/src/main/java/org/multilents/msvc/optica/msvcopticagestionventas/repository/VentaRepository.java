package org.multilents.msvc.optica.msvcopticagestionventas.repository;

import org.multilents.msvc.optica.msvcopticagestionventas.entity.VentaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VentaRepository  extends JpaRepository<VentaEntity, UUID> {

    @Query("select c from VentaEntity c where c.estado=1")
    public Page<VentaEntity> findAllPage(Pageable pageable);

    @Query("select c from VentaEntity c where c.producto = :productoId and c.estado=1")
    public Page<VentaEntity>  findByProducto(UUID productoId, Pageable pageable);

    @Query("select c from VentaEntity c where c.cliente = ?1 and c.estado=1")
    public Page<VentaEntity>  findByCliente(UUID clienteId, Pageable pageable);
}
