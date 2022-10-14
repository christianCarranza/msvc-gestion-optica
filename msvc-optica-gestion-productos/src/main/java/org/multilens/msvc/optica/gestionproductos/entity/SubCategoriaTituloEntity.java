package org.multilens.msvc.optica.gestionproductos.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "sub_categoria_titulos")
public class SubCategoriaTituloEntity   extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_sub_categoria_titulo", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CategoriaEntity.class)
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntity categoria;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    private static final long serialVersionUID = -2170897015344177815L;
}
