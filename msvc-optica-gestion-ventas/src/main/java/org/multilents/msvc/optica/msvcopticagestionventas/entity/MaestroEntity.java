package org.multilents.msvc.optica.msvcopticagestionventas.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "maestros")
public class MaestroEntity extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_maestro", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "correlativo", nullable = false)
    private Integer correlativo;

    @Column(name = "prefijo", nullable = false)
    private Integer prefijo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    private static final long serialVersionUID = -2170897015344177815L;

}
