package org.multilens.msvc.optica.gestionproductos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.multilens.msvc.optica.gestionproductos.entity.GaleriaEntity;
import org.multilens.msvc.optica.gestionproductos.entity.ResenaEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@EqualsAndHashCode(callSuper = true)
public class ProductoDTO extends AuditoriaDTO {
    private UUID id;
    private SubCategoriaDTO subCategoria;
    private String nombre;
    private String palabraClave;
    private String url;
    private String imagen;
    private Double precio;
    private Integer stock;
    private CuponDTO cupon;
    private PromocionDTO promocion;
    private BannerDTO topBanner;
    private SliderDTO Slider;
    private String especificaciones;
    private String descripcion;
    private String resumen;
    private String defaultBanner;
    private String verticalSlider;
    private Integer vista;
    private Integer ventas;
    private MaestroDTO formatoVideo;
    private String video;

    // OTROS
    private Set<GaleriaDTO> galeria = new HashSet<>();
    private Set<ResenaDTO> resena = new HashSet<>();
    private Set<DetalleDTO> detalle = new HashSet<>();
}
