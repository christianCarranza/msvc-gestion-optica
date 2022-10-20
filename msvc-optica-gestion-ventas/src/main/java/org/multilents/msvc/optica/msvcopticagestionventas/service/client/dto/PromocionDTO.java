package org.multilents.msvc.optica.msvcopticagestionventas.service.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.AuditoriaDTO;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.MaestroDTO;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PromocionDTO extends AuditoriaDTO {
    private UUID id;
    private MaestroDTO tipo;
    private Double descuento;
    private LocalDateTime fechaTermino;
}
