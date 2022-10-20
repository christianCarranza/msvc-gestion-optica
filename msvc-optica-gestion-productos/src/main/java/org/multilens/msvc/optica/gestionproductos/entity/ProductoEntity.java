package org.multilens.msvc.optica.gestionproductos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
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
    @Column(name = "id_producto", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_sub_categoria", nullable = false)
    private SubCategoriaEntity subCategoria;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "palabra_clave", nullable = false)
    private String palabraClave;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_cupon", nullable = false)
    private CuponEntity cupon;

    @ManyToOne
    @JoinColumn(name = "id_promocion", nullable = false)
    private PromocionEntity promocion;

    @OneToOne
    @JoinColumn(name = "id_top_banner", nullable = false)
    private BannerEntity topBanner;

    @OneToOne
    @JoinColumn(name = "id_horizontal_slider", nullable = false)
    private SliderEntity Slider;

    @Column(name = "especificaciones", nullable = false)
    private String especificaciones;

    @Column(name = "detalles", nullable = false)
    private String detalles;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "default_banner", nullable = false)
    private String defaultBanner;

    @Column(name = "vertical_slider", nullable = false)
    private String verticalSlider;

    private static final long serialVersionUID = -2170897015344177815L;

}
