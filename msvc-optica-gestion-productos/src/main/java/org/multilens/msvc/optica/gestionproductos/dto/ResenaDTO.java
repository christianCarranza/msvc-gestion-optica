package org.multilens.msvc.optica.gestionproductos.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ResenaDTO extends AuditoriaDTO {
    private UUID id;
    private ProductoDTO producto;
    private Integer calificacion;
    private String comentario;
}
