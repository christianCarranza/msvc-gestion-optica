package org.multilens.msvc.optica.gestionproductos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.multilens.msvc.optica.gestionproductos.dto.MaestroDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "productos")
public class ProductoEntity extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_producto", updatable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_sub_categoria")
    private SubCategoriaEntity subCategoria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "palabra_clave")
    private String palabraClave;

    @Column(name = "url")
    private String url;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_cupon")
    private CuponEntity cupon;

    @ManyToOne
    @JoinColumn(name = "id_promocion")
    private PromocionEntity promocion;

    @OneToOne
    @JoinColumn(name = "id_top_banner")
    private BannerEntity topBanner;

    @OneToOne
    @JoinColumn(name = "id_horizontal_slider")
    private SliderEntity Slider;

    @Column(name = "especificaciones")
    private String especificaciones;


    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "default_banner")
    private String defaultBanner;

    @Column(name = "vertical_slider")
    private String verticalSlider;

    @Column(name = "vista")
    private Integer vista;

    @Column(name = "ventas")
    private Integer ventas;

    @ManyToOne
    @JoinColumn(name = "id_formato_video")
    private MaestroEntity formatoVideo;

    @Column(name = "video")
    private String video;


    //otros

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GaleriaEntity> galeria = new HashSet<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResenaEntity> resena = new HashSet<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleEntity> detalle = new HashSet<>();

    private static final long serialVersionUID = -2170897015344177815L;

}
