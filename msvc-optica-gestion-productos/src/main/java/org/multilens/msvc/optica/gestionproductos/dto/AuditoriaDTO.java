package org.multilens.msvc.optica.gestionproductos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuditoriaDTO {
    private Integer estado;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private Long usuarioCreacion;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaModificacion;
    private Long usuarioModificacion;
}
