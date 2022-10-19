package org.multilents.msvc.optica.gestionusuarios.rest;

import lombok.extern.slf4j.Slf4j;
import org.multilents.msvc.optica.gestionusuarios.dto.UsuarioDTO;
import org.multilents.msvc.optica.gestionusuarios.service.UsuarioService;
import org.multilents.msvc.optica.gestionusuarios.utils.CodeEnum;
import org.multilents.msvc.optica.gestionusuarios.utils.ConstantesUtil;
import org.multilents.msvc.optica.gestionusuarios.utils.CustomResponse;
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
@RequestMapping(ConstantesUtil.API_USUARIO)
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/findAllPage")
    @ResponseBody
    public ResponseEntity<CustomResponse> findAllPage(Pageable paginador){
        Page<UsuarioDTO> lstUsuarioDTO= this.usuarioService.findAllPage(paginador);
        if (lstUsuarioDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstUsuarioDTO, "Información encontrada");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CustomResponse> findAll(){
        List<UsuarioDTO> lstUsuarioDTO= this.usuarioService.findAll();
        if (lstUsuarioDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstUsuarioDTO, "Información encontrada");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomResponse> findById(@PathVariable UUID id) {
        var persona = this.usuarioService.findById(id);
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), persona, null);
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping("/byLikeCorreo")
    @ResponseBody
    public ResponseEntity<CustomResponse> findByLikeCorreo(@RequestParam(name = "correo", defaultValue = "") String correo){
        List<UsuarioDTO> lstUsuarioDTO= this.usuarioService.findByLikeCorreo(correo);
        CustomResponse rpta;
        if (lstUsuarioDTO.isEmpty()) {
            rpta = new CustomResponse(String.valueOf(HttpStatus.NO_CONTENT.value()), "No se encontraron registros");
        }else{
            rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), lstUsuarioDTO, "Información encontrada");
        }
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @GetMapping("/obtenerPorUsername")
    @ResponseBody
    public ResponseEntity<CustomResponse> obtenerPorUsername(@RequestParam(name = "username", defaultValue = "") String username){
        UsuarioDTO usuarioDTO= this.usuarioService.obtenerPorUsername(username);
        return getCustomResponseResponseEntity(usuarioDTO);
    }

    @GetMapping("/findByUsername")
    @ResponseBody
    public ResponseEntity<CustomResponse> findByUsername(@RequestParam(name = "correo", defaultValue = "") String correo){
        UsuarioDTO usuarioDTO= this.usuarioService.findByUsername(correo);
        return getCustomResponseResponseEntity(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> save(@Valid @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = this.usuarioService.save(usuarioDTO);
        CustomResponse r = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), usuario, "Usuario registrado correctamente.");
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    @ResponseBody
    public ResponseEntity<CustomResponse> update( @PathVariable UUID id,  @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO result = this.usuarioService.update(id, usuarioDTO);
        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), result, "Usuario actualizada correctamente.");
        return new ResponseEntity<>(rpta, HttpStatus.OK);

    }

    @PutMapping("delete/{id}")
    public ResponseEntity<CustomResponse> delete( @PathVariable UUID id,  @RequestBody UsuarioDTO usuarioDTO) {
        Boolean result = this.usuarioService.delete(id, usuarioDTO);
        CustomResponse rpta = new CustomResponse(Boolean.TRUE.equals(result)?"1":"0", Boolean.TRUE.equals(result) ? "Eliminado correctamente":"Error al eliminar");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    //util
    private ResponseEntity<CustomResponse> getCustomResponseResponseEntity(UsuarioDTO usuarioDTO) {
        CustomResponse rpta;
        if (usuarioDTO.getId() == null) {
            rpta = new CustomResponse(String.valueOf(HttpStatus.NO_CONTENT.value()), "No se encontraron registros");
        }else{
            rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), usuarioDTO, "Información encontrada");
        }
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

}
