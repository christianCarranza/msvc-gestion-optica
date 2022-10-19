package org.multilents.msvc.optica.gestionusuarios.service;

import org.multilents.msvc.optica.gestionusuarios.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService extends GenericService<UsuarioDTO>{
    UsuarioDTO findByUsername(String usuario);
    UsuarioDTO obtenerPorUsername(String usuario);
    List<UsuarioDTO> findByLikeCorreo(String correo);

}
