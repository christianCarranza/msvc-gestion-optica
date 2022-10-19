package org.multilens.msvc.optica.gestionproductos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BannerDTO  extends AuditoriaDTO{
    private  UUID id;
    private  String h3Tag;
    private  String p1Tag;
    private  String h4Tag;
    private  String p2Tag;
    private  String spanTag;
    private  String buttonTag;
    private  String imgTag;
}
