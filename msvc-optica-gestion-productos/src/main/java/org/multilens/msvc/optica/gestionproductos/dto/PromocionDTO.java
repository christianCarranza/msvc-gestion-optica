package org.multilens.msvc.optica.gestionproductos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
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
