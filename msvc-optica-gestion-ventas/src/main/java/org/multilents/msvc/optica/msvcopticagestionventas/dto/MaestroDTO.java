package org.multilents.msvc.optica.msvcopticagestionventas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MaestroDTO extends AuditoriaDTO {
    private UUID id;
    private String nombre;
    private String url;
    private String imagen;
    private String icono;
    private Integer vista;
}
