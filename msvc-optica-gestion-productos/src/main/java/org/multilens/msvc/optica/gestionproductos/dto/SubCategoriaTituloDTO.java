package org.multilens.msvc.optica.gestionproductos.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubCategoriaTituloDTO  extends AuditoriaDTO{
    private  UUID id;
    private  CategoriaDTO categoria;
    private  String descripcion;
}
