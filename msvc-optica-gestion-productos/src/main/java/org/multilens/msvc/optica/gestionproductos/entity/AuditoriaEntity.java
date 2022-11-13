package org.multilens.msvc.optica.gestionproductos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public class AuditoriaEntity {

    @Column(name = "estado", nullable = false)
    private Integer estado = 0;

    @Column(name = "fecha_creacion", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "usuario_creacion", nullable = false,  columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID usuarioCreacion;

    @Column(name = "fecha_modificacion")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaModificacion;

    @Column(name = "usuario_modificacion",  columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID usuarioModificacion;
}