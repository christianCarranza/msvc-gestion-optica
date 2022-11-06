package org.multilents.msvc.optica.msvcopticagestionventas.rest;

import lombok.extern.slf4j.Slf4j;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.VentaDTO;
import org.multilents.msvc.optica.msvcopticagestionventas.service.VentaService;
import org.multilents.msvc.optica.msvcopticagestionventas.utils.CodeEnum;
import org.multilents.msvc.optica.msvcopticagestionventas.utils.ConstantesUtil;
import org.multilents.msvc.optica.msvcopticagestionventas.utils.CustomResponse;
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
@RequestMapping(ConstantesUtil.API_VENTAS)
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("/findAllPage")
    @ResponseBody
    public ResponseEntity<CustomResponse> findAllPage(Pageable paginador){
        Page<VentaDTO> lstVentaDTO= this.ventaService.findAllPage(paginador);
        if (lstVentaDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstVentaDTO, "Información encontrada");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CustomResponse> findAll(){
        List<VentaDTO> lstVentaDTO= this.ventaService.findAll();
        if (lstVentaDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstVentaDTO,  "Información encontrada");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomResponse> findById(@PathVariable UUID id) {
        var persona = this.ventaService.findById(id);
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), persona, null);
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping("/findByProducto/{productoId}")
    @ResponseBody
    public ResponseEntity<CustomResponse> findByProducto( @PathVariable UUID productoId, Pageable paginador){
        Page<VentaDTO> lstVentaDTO= this.ventaService.findByProducto(productoId, paginador);
        return getCustomResponseEntity(lstVentaDTO);
    }

    @GetMapping("/findByCliente/{clienteId}")
    @ResponseBody
    public ResponseEntity<CustomResponse> findByCliente(@PathVariable UUID clienteId , Pageable paginador){
        Page<VentaDTO> lstVentaDTO = this.ventaService.findByCliente(clienteId, paginador);
        return getCustomResponseEntity(lstVentaDTO);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> save(@Valid @RequestBody VentaDTO ventaDTO){
        VentaDTO venta = this.ventaService.save(ventaDTO);
        CustomResponse r = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), venta, "Venta registrado correctamente.");
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    @ResponseBody
    public ResponseEntity<CustomResponse> update( @PathVariable UUID id,  @RequestBody VentaDTO ventaDTO) {
        VentaDTO result = this.ventaService.update(id, ventaDTO);
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), result, "Venta actualizada correctamente.");
        return new ResponseEntity<>(rpta, HttpStatus.OK);

    }

    @PutMapping("delete/{id}")
    public ResponseEntity<CustomResponse> delete( @PathVariable UUID id,  @RequestBody VentaDTO ventaDTO) {
        Boolean result = this.ventaService.delete(id, ventaDTO);
        CustomResponse rpta = new CustomResponse(Boolean.TRUE.equals(result)?"1":"0", Boolean.TRUE.equals(result) ? "Eliminado correctamente":"Error al eliminar");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    //util
    private ResponseEntity<CustomResponse> getCustomResponseEntity(Page<VentaDTO> lstVentaDTO) {
        CustomResponse rpta;
        if (lstVentaDTO.isEmpty()) {
            rpta = new CustomResponse(String.valueOf(HttpStatus.NO_CONTENT.value()), ConstantesUtil.MENSAJE_RESPUESTA_NO_ENCONTRADO);
        }else{
            rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstVentaDTO,  ConstantesUtil.MENSAJE_RESPUESTA_EXITOSA);
        }
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

}
