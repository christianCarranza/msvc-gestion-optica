package org.multilens.msvc.optica.gestionproductos.service;

import org.multilens.msvc.optica.gestionproductos.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService extends GenericService<CategoriaDTO>{
    List<CategoriaDTO> findByLikeNombre(String nombre);
}
