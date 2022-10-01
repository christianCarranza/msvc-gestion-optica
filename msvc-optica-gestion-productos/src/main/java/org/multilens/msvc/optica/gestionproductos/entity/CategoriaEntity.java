package org.multilens.msvc.optica.gestionproductos.entity;

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
@Table(name = "categorias")
public class CategoriaEntity  extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", columnDefinition = "varchar(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID uuid;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "icono", nullable = false)
    private String icono;

    @Column(name = "vista", nullable = false)
    private String vista;

    private static final long serialVersionUID = -2170897015344177815L;

}
