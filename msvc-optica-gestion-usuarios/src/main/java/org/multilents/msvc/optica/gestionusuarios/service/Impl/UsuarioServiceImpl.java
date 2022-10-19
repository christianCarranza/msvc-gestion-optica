package org.multilents.msvc.optica.gestionusuarios.service.Impl;


import org.multilents.msvc.optica.gestionusuarios.dto.UsuarioDTO;
import org.multilents.msvc.optica.gestionusuarios.dto.mapper.UsuarioMapper;
import org.multilents.msvc.optica.gestionusuarios.entity.UsuarioEntity;
import org.multilents.msvc.optica.gestionusuarios.exception.NotFoundException;
import org.multilents.msvc.optica.gestionusuarios.repository.UsuarioRepository;
import org.multilents.msvc.optica.gestionusuarios.service.UsuarioService;
import org.multilents.msvc.optica.gestionusuarios.utils.FechasUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private static final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Page<UsuarioDTO> findAllPage(Pageable paginador) {
        Page<UsuarioEntity> lstUsuarioEntity = usuarioRepository.findAllPage(paginador);
        List<UsuarioDTO>  result = lstUsuarioEntity.stream().map(usuarioMapper::entityToGetDto).collect(Collectors.toList());

        return (Page<UsuarioDTO>) FechasUtil.paginate(result, paginador, lstUsuarioEntity.getTotalElements());
    }

    @Override
    public List<UsuarioDTO> findAll() {
        var lstUsuarioEntity = usuarioRepository.findAll();

        
        return lstUsuarioEntity.stream().map(usuarioMapper::entityToGetDto).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(UUID id) {

        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un registro para el ID suministrado."));

        return usuarioMapper.entityToGetDto(usuario);
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        var usuarioEntity = usuarioMapper.postDtoToEntity(usuarioDTO);
        var save = this.usuarioRepository.save(usuarioEntity);
        return usuarioMapper.entityToGetDto(save);
    }

    @Override
    public UsuarioDTO update(UUID id, UsuarioDTO usuarioDTO) {
        UsuarioEntity entity = this.usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Caterogia no encontrado para este id :: " + id));
        UsuarioEntity updated = usuarioMapper.postDtoToEntity(usuarioDTO);
        if(updated.getNombre() != null){
            entity.setNombre(updated.getNombre());
        }
        if(updated.getApellidoMaterno() != null){
            entity.setApellidoMaterno(updated.getApellidoMaterno());
        }
        if(updated.getApellidoMaterno() != null){
            entity.setApellidoMaterno(updated.getApellidoMaterno());
        }
        if(updated.getPassword() != null){
            entity.setPassword(updated.getPassword());
        }
        if(updated.getCelular() != null){
            entity.setCelular(updated.getCelular());
        }
        if(updated.getDireccion() != null){
            entity.setDireccion(updated.getDireccion());
        }
        if(updated.getFoto() != null){
            entity.setFoto(updated.getFoto());
        }
        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(updated.getUsuarioCreacion());
        usuarioRepository.save(entity);
        return usuarioMapper.entityToGetDto(entity);
    }

    @Override
    public Boolean delete(UUID id, UsuarioDTO usuarioDTO) {
        UsuarioEntity entity = this.usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(usuarioDTO.getUsuarioCreacion());
        entity.setEstado(usuarioDTO.getEstado()); // 0 = Inactivo, 1 = Activo
        this.usuarioRepository.save(entity);
        return true;
    }

    @Override
    public UsuarioDTO findByUsername(String usuario) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findByUsername(usuario);
        return usuarioMapper.entityToGetDto(usuarioEntity);
    }

    @Override
    public UsuarioDTO obtenerPorUsername(String usuario) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.obtenerPorUsername(usuario);
        return usuarioMapper.entityToGetDto(usuarioEntity);
    }

    @Override
    public List<UsuarioDTO> findByLikeCorreo(String correo) {
        Optional<UsuarioEntity> lstUsuarioEntity = this.usuarioRepository.findByLikeCorreo(correo);
        return lstUsuarioEntity.stream().map(usuarioMapper::entityToGetDto).collect(Collectors.toList());
    }
}
