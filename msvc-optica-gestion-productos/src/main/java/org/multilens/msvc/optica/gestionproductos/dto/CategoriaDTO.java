package org.multilens.msvc.optica.gestionproductos.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CategoriaDTO extends AuditoriaDTO{
    private UUID id;
    private String nombre;
    private String url;
    private String imagen;
    private String icono;
    private Integer vista;
    private Set<SubCategoriaTituloDTO> subCategoriaTitulo = new HashSet<>();
}
