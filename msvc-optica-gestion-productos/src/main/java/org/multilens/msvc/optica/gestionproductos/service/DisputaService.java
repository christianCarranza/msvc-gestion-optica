package org.multilens.msvc.optica.gestionproductos.service;

import org.multilens.msvc.optica.gestionproductos.dto.DisputaDTO;

import java.util.List;


public interface DisputaService extends GenericService<DisputaDTO>{
    List<DisputaDTO> findByLikeComentario(String comentario);
}
