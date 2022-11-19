package org.multilens.msvc.optica.gestionproductos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper=false)
public class SubCategoriaDTO extends AuditoriaDTO implements Serializable {
    private UUID id;
    private SubCategoriaTituloDTO subCategoriaTitulos;
    private String nombre;
    private String url;
    private String imagen;
    private String inventario;
    private Integer vista;
}
