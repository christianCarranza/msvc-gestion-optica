package org.multilens.msvc.optica.gestionproductos.service.Impl;

import org.multilens.msvc.optica.gestionproductos.dto.DisputaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.DisputaMapper;
import org.multilens.msvc.optica.gestionproductos.entity.DisputaEntity;
import org.multilens.msvc.optica.gestionproductos.exception.NotFoundException;
import org.multilens.msvc.optica.gestionproductos.repository.DisputaRepository;
import org.multilens.msvc.optica.gestionproductos.service.DisputaService;
import org.multilens.msvc.optica.gestionproductos.utils.FechasUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DisputaServiceImpl implements DisputaService {
    private final DisputaRepository disputaRepository;

    private static final DisputaMapper disputaMapper = DisputaMapper.INSTANCE;

    public DisputaServiceImpl(DisputaRepository disputaRepository) {
        this.disputaRepository = disputaRepository;
    }


    @Override
    public Page<DisputaDTO> findAllPage(Pageable paginador) {
        Page<DisputaEntity> lstDisputaEntity = disputaRepository.findAllPage(paginador);
        List<DisputaDTO>  result = lstDisputaEntity.stream().map(disputaMapper::entityToGetDto).collect(Collectors.toList());
        return (Page<DisputaDTO>) FechasUtil.paginate(result, paginador, lstDisputaEntity.getTotalElements());
    }

    @Override
    public List<DisputaDTO> findAll() {
        var lstDisputaEntity = disputaRepository.findAll();
        return lstDisputaEntity.stream().map(disputaMapper::entityToGetDto).collect(Collectors.toList());
    }

    @Override
    public DisputaDTO findById(UUID id) {
        DisputaEntity disputa = this.disputaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un registro para el ID suministrado."));
        return disputaMapper.entityToGetDto(disputa);
    }

    @Override
    public DisputaDTO save(DisputaDTO disputaDTO) {
        var disputaEntity = disputaMapper.postDtoToEntity(disputaDTO);
        var save = this.disputaRepository.save(disputaEntity);
        return disputaMapper.entityToGetDto(save);
    }

    @Override
    public DisputaDTO update(UUID id, DisputaDTO disputaDTO) {
        DisputaEntity entity = this.disputaRepository.findById(id).orElseThrow(() -> new NotFoundException("Caterogia no encontrado para este id :: " + id));
        DisputaEntity updated = disputaMapper.postDtoToEntity(disputaDTO);
        if(updated.getProducto() != null){
            entity.setProducto(updated.getProducto());
        }
        if(updated.getDisputa() != null){
            entity.setDisputa(updated.getDisputa());
        }
        if(updated.getComentario() != null){
            entity.setComentario(updated.getComentario());
        }

        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(updated.getUsuarioCreacion());
        disputaRepository.save(entity);
        return disputaMapper.entityToGetDto(entity);
    }

    @Override
    public Boolean delete(UUID id, DisputaDTO disputaDTO) {
        DisputaEntity entity = this.disputaRepository.findById(id).orElseThrow(RuntimeException::new);
        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(disputaDTO.getUsuarioCreacion());
        entity.setEstado(disputaDTO.getEstado()); // 0 = Inactivo, 1 = Activo
        this.disputaRepository.save(entity);
        return true;
    }

    @Override
    public List<DisputaDTO> findByLikeComentario(String nombre) {
        Optional<DisputaEntity> lstDisputaEntity = this.disputaRepository.findByLikeComentario(nombre);
        return lstDisputaEntity.stream().map(disputaMapper::entityToGetDto).collect(Collectors.toList());
    }
}
