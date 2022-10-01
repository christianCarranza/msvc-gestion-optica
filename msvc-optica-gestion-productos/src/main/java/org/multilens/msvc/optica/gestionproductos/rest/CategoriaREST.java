package org.multilens.msvc.optica.gestionproductos.rest;

import lombok.extern.slf4j.Slf4j;
import org.multilens.msvc.optica.gestionproductos.dto.CategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.service.CategoriaService;
import org.multilens.msvc.optica.gestionproductos.utils.ConstantesUtil;
import org.multilens.msvc.optica.gestionproductos.utils.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ConstantesUtil.API_CATEGORIA)
public class CategoriaREST {
    private final CategoriaService categoriaService;

    public CategoriaREST(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<CustomResponse> findByLike(){

        List<CategoriaDTO> lstCategoriaDTO= this.categoriaService.findByLike(null);
        if (lstCategoriaDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CustomResponse rpta = new CustomResponse(ConstantesUtil.TITULO_ALERTAS, lstCategoriaDTO, "Información encontrada");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

}
