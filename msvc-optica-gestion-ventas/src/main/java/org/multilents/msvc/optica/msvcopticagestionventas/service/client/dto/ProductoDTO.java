package org.multilents.msvc.optica.msvcopticagestionventas.service.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.AuditoriaDTO;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProductoDTO extends AuditoriaDTO {
    private UUID id;
    private String nombre;
    private String palabraClave;
    private String url;
    private String imagen;
    private Double precio;
    private CuponDTO cupon;
    private String descripcion;
}
