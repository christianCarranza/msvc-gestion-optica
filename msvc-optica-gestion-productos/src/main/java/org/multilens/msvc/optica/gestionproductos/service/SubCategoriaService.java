package org.multilens.msvc.optica.gestionproductos.service;


import org.multilens.msvc.optica.gestionproductos.dto.SubCategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface SubCategoriaService extends GenericService<SubCategoriaDTO>{

    List<SubCategoriaDTO> findByLikeNombre(String nombre);

    List<SubCategoriaDTO> findByCategoria(UUID id);
}
