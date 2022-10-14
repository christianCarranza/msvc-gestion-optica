package org.multilens.msvc.optica.gestionproductos.dto;


import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoriaDTO extends AuditoriaDTO   implements Serializable {
    private UUID id;
    private String nombre;
    private String url;
    private String imagen;
    private String icono;
    private Integer vista;
    private List<SubCategoriaTituloDTO> subCategoriaTitulo;
}
