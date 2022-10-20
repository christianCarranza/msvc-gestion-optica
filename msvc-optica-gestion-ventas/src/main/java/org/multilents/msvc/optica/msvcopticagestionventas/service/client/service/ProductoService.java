package org.multilents.msvc.optica.msvcopticagestionventas.service.client.service;

import org.multilents.msvc.optica.msvcopticagestionventas.service.client.dto.ProductoDTO;

import java.util.UUID;

public interface ProductoService {
    ProductoDTO findById(UUID id);
}
