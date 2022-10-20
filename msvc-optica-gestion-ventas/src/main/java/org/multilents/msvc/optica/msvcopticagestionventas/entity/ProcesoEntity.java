package org.multilents.msvc.optica.msvcopticagestionventas.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "procesos")
public class ProcesoEntity  extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_proceso", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_venta", nullable = false)
    private VentaEntity venta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_momento", nullable = false)
    private MaestroEntity momento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado_proceso", nullable = false)
    private MaestroEntity estadoProceso;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "fecha_proceso", nullable = false)
    private LocalDateTime fechaProceso;

}
