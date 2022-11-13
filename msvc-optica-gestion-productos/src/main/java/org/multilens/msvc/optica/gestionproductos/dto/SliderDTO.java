package org.multilens.msvc.optica.gestionproductos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SliderDTO  extends AuditoriaDTO {
    private UUID id;
    private String h4Tag;
    private String h31Tag;
    private String h32Tag;
    private String h33Tag;
    private String h34sTag;
    private String buttonTag;
    private String imgTag;
}
