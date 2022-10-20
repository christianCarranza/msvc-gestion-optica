package org.multilents.msvc.optica.msvcopticagestionventas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.multilents.msvc.optica.msvcopticagestionventas.service.client.dto.ProductoDTO;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class VentaDTO extends MaestroDTO implements Serializable {
    private  UUID id;
    private  ProductoDTO producto;
    private  UUID cliente;
    private  MaestroDTO estadoVenta;
    private  Double cantidad;
    private  Double precioTotal;
}
