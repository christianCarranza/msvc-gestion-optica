package org.multilens.msvc.optica.gestionproductos.dto;


import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoriaDTO extends AuditoriaDTO {
    private UUID uuid;
    private String nombre;
    private String url;
    private String imagen;
    private String icono;
    private String vista;
}
