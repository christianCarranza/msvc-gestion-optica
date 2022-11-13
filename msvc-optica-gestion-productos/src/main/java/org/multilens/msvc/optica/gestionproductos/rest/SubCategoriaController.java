package org.multilens.msvc.optica.gestionproductos.rest;

import lombok.extern.slf4j.Slf4j;
import org.multilens.msvc.optica.gestionproductos.dto.CategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.SubCategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.service.SubCategoriaService;
import org.multilens.msvc.optica.gestionproductos.utils.CodeEnum;
import org.multilens.msvc.optica.gestionproductos.utils.ConstantesUtil;
import org.multilens.msvc.optica.gestionproductos.utils.CustomResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(ConstantesUtil.API_SUBCATEGORIA)
public class SubCategoriaController {

    private final SubCategoriaService subCategoriaService;

    public SubCategoriaController(SubCategoriaService subCategoriaService) {
        this.subCategoriaService = subCategoriaService;
    }

    @GetMapping("/findAllPage")
    @ResponseBody
    public ResponseEntity<CustomResponse> findAllPage(Pageable paginador){
        Page<SubCategoriaDTO> lstSubCategoriaDTO= this.subCategoriaService.findAllPage(paginador);
        if (lstSubCategoriaDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstSubCategoriaDTO, "Información encontrada");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CustomResponse> findAll(){
        List<SubCategoriaDTO>  lstSubCategoriaDTO = this.subCategoriaService.findAll();
        if (lstSubCategoriaDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstSubCategoriaDTO, "Información encontrada");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomResponse> findById(@PathVariable UUID id) {
        SubCategoriaDTO subCategoria = this.subCategoriaService.findById(id);
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), subCategoria, null);
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping("findByCategoria/{id}")
    public ResponseEntity<CustomResponse> findByCategoria(@PathVariable UUID id) {
        List<SubCategoriaDTO>  lstSubCategoriaDTO = this.subCategoriaService.findByCategoria(id);
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstSubCategoriaDTO, "Información encontrada");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping("/byNombre")
    @ResponseBody
    public ResponseEntity<CustomResponse> findByLikeNombre(@RequestParam(name = "nombre", defaultValue = "") String nombre){
        List<SubCategoriaDTO> lstCategoriaDTO= this.subCategoriaService.findByLikeNombre(nombre);
        CustomResponse rpta = null;
        if (lstCategoriaDTO.isEmpty()) {
            rpta = new CustomResponse(String.valueOf(HttpStatus.NO_CONTENT.value()), "No se encontraron registros");
        }else{
            rpta = new CustomResponse(ConstantesUtil.TITULO_ALERTAS, lstCategoriaDTO, "Información encontrada");
        }
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> save(@Valid @RequestBody SubCategoriaDTO subCategoriaDTO){
        SubCategoriaDTO categoria = this.subCategoriaService.save(subCategoriaDTO);
        CustomResponse r = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), categoria, "Categoria registrado correctamente.");
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    @ResponseBody
    public ResponseEntity<CustomResponse> update( @PathVariable UUID id,  @RequestBody SubCategoriaDTO subCategoriaDTO) {
        SubCategoriaDTO result = this.subCategoriaService.update(id, subCategoriaDTO);
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), result, "Categoria actualizada correctamente.");
        return new ResponseEntity<>(rpta, HttpStatus.OK);

    }

    @PutMapping("delete/{id}")
    public ResponseEntity<CustomResponse> delete( @PathVariable UUID id,  @RequestBody SubCategoriaDTO subCategoriaDTO) {
        Boolean result = this.subCategoriaService.delete(id, subCategoriaDTO);
        CustomResponse rpta = new CustomResponse(Boolean.TRUE.equals(result)?"1":"0", Boolean.TRUE.equals(result) ? "Eliminado correctamente":"Error al eliminar");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }
}
