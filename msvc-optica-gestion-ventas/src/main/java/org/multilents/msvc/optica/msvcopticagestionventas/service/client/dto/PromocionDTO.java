package org.multilents.msvc.optica.msvcopticagestionventas.service.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.AuditoriaDTO;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.MaestroDTO;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PromocionDTO extends AuditoriaDTO {
    private UUID id;
    private MaestroDTO tipo;
    private Double descuento;
    private LocalDateTime fechaTermino;
}
