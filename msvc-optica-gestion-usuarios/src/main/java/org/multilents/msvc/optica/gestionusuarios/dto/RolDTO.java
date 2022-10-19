package org.multilents.msvc.optica.gestionusuarios.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RolDTO extends AuditoriaDTO implements Serializable {
    private final UUID id;
    private final String nombre;
}
