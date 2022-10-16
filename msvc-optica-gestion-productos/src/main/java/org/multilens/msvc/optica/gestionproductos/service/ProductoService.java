package org.multilens.msvc.optica.gestionproductos.service;

import org.multilens.msvc.optica.gestionproductos.dto.ProductoDTO;

import java.util.List;

public interface ProductoService extends GenericService<ProductoDTO>{
    List<ProductoDTO> findByLikeNombre(String nombre);
}