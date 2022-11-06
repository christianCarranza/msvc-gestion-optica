package org.multilents.msvc.optica.msvcopticagestionventas.service.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.AuditoriaDTO;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CuponDTO extends AuditoriaDTO {
    private UUID id;
    private String descripcion;
    private Double descuento;
    private LocalDateTime fechaTermino;
}
