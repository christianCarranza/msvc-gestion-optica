package org.multilens.msvc.optica.gestionproductos.dto;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubCategoriaTituloDTO  extends AuditoriaDTO  implements Serializable {
    private  UUID id;
    private  CategoriaDTO categoria;
    private  String descripcion;
}
