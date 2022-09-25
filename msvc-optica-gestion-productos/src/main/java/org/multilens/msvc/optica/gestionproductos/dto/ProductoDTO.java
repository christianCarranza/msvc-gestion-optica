package org.multilens.msvc.optica.gestionproductos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductoDTO implements Serializable {
    private final Long id;
    private final String nombre;
    private final String descripcion;
    private final Double precio;
    private final Double stock;
    private final String estado;
}
