package org.multilens.msvc.optica.gestionproductos.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse {

    private CodeEnum code;
    private Object message;
    private Object data;

}
