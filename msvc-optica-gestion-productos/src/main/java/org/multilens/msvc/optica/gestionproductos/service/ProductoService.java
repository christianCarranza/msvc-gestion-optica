package org.multilens.msvc.optica.gestionproductos.service;

import org.multilens.msvc.optica.gestionproductos.dto.ProductoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductoService extends GenericService<ProductoDTO>{
    Page<ProductoDTO> findAllPageActive(Pageable paginador);
    List<ProductoDTO> findByLikeNombre(String nombre);
    ProductoDTO findByIdActive(UUID id);
}