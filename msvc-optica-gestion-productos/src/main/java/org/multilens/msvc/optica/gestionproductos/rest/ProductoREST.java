package org.multilens.msvc.optica.gestionproductos.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.multilens.msvc.optica.gestionproductos.commons.CodeEnum;
import org.multilens.msvc.optica.gestionproductos.commons.CustomResponse;
import org.multilens.msvc.optica.gestionproductos.dto.ProductoDTO;
import org.multilens.msvc.optica.gestionproductos.rest.generic.GenericController;
import org.multilens.msvc.optica.gestionproductos.service.service.ProductoService;
import static org.multilens.msvc.optica.gestionproductos.commons.GlobalConstants.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(API_PRODUCTO)
public class ProductoREST extends GenericController {

    private String api = "productos";
    private final ProductoService productoService;

    public ProductoREST(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<?> findByLike(){

        try {
            List<ProductoDTO> lstProductoDTO= this.productoService.findByLike(null);
            if (lstProductoDTO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CustomResponse.builder().code(CodeEnum.WARNING)
                        .message("No hay productos").build());
            }
            return ResponseEntity.ok(
                    CustomResponse.builder().code(CodeEnum.SUCCESS).message("Informacion encontrada")
                            .data(lstProductoDTO).build());
        } catch (Exception e) {
//            log.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
