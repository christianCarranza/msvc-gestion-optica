package org.multilents.msvc.optica.gestionusuarios.repository;

import org.multilents.msvc.optica.gestionusuarios.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioEntity, UUID> {

    @Query("select c from UsuarioEntity c where UPPER(c.correo) like UPPER(:correo) ORDER BY c.correo")
    public Optional<UsuarioEntity> findByLikeCorreo(@Param("nombre") String correo);

    @Query("select c from UsuarioEntity c where c.estado=1")
    public Page<UsuarioEntity> findAllPage(Pageable pageable);

    public UsuarioEntity findByUsername(String username);

    @Query("select c from UsuarioEntity c where c.username = ?1 ORDER BY c.nombre")
    public UsuarioEntity obtenerPorUsername(String username);
}
