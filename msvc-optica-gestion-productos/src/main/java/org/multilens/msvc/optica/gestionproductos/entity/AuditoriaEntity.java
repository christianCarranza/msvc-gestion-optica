package org.multilens.msvc.optica.gestionproductos.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public class AuditoriaEntity {

    @Column(name = "estado", nullable = false)
    private Integer estado = 0;

    @Column(name = "fecha_creación", nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "usuario_creacion", nullable = false)
    private Long usuarioCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "usuario_modificación")
    private Long usuarioModificacion;

}