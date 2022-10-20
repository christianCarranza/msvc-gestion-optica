package org.multilents.msvc.optica.msvcopticagestionventas.service;

import org.multilents.msvc.optica.msvcopticagestionventas.dto.VentaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface VentaService extends GenericService<VentaDTO>{

    public Page<VentaDTO>  findByProducto(UUID productoId, Pageable pageable);

    public Page<VentaDTO>  findByCliente(UUID clienteId, Pageable pageable);

}
