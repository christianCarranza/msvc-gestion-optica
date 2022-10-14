package org.multilens.msvc.optica.gestionproductos.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class SubCategoriaDTO implements Serializable {
    private UUID id;
    private SubCategoriaTituloDTO subCategoriaTitulos;
    private String nombre;
    private String url;
    private String imagen;
    private String inventario;
    private Integer vista;
}
