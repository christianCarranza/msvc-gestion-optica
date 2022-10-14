package org.multilens.msvc.optica.gestionproductos.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "categorias")
public class CategoriaEntity  extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_categoria", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "icono", nullable = false)
    private String icono;

    @Column(name = "vista", nullable = false)
    private Integer vista;

//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, mappedBy = "categoria")
    @OneToMany(mappedBy = "categoria", targetEntity = SubCategoriaTituloEntity.class)
    private List<SubCategoriaTituloEntity> subCategoriaTitulo;

    private static final long serialVersionUID = -2170897015344177815L;

}
