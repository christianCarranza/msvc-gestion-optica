package org.multilents.msvc.optica.msvcopticagestionventas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProcesoDTO extends MaestroDTO implements Serializable {
    private UUID id;
    private VentaDTO venta;
    private MaestroDTO momento;
    private MaestroDTO estadoProceso;
    private String comentario;
    private LocalDateTime fechaProceso;
}
