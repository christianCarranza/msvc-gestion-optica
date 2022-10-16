package org.multilens.msvc.optica.gestionproductos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProductoDTO extends AuditoriaDTO {
    private UUID id;
    private SubCategoriaDTO subCategoria;
    private String nombre;
    private String palabraClave;
    private String url;
    private String imagen;
    private Double precio;
    private Integer stock;
}
