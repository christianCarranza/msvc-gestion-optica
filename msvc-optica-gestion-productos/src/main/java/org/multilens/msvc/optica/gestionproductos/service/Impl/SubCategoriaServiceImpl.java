package org.multilens.msvc.optica.gestionproductos.service.Impl;

import org.multilens.msvc.optica.gestionproductos.dto.CategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.SubCategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.SubCategoriaMapper;
import org.multilens.msvc.optica.gestionproductos.entity.CategoriaEntity;
import org.multilens.msvc.optica.gestionproductos.entity.SubCategoriaEntity;
import org.multilens.msvc.optica.gestionproductos.exception.NotFoundException;
import org.multilens.msvc.optica.gestionproductos.repository.SubCategoriaRepository;
import org.multilens.msvc.optica.gestionproductos.service.SubCategoriaService;
import org.multilens.msvc.optica.gestionproductos.utils.FechasUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubCategoriaServiceImpl implements SubCategoriaService {

    private final SubCategoriaRepository subCategoriaRepository;

    private static final SubCategoriaMapper subCategoriaMapper = SubCategoriaMapper.INSTANCE;

    public SubCategoriaServiceImpl(SubCategoriaRepository subCategoriaRepository) {
        this.subCategoriaRepository = subCategoriaRepository;
    }

    @Override
    public Page<SubCategoriaDTO> findAllPage(Pageable paginador) {
        Page<SubCategoriaEntity> LstSubCategoriaEntity = subCategoriaRepository.findAllPage(paginador);
        List<SubCategoriaDTO>  result = LstSubCategoriaEntity.stream().map(subCategoriaMapper::entityToGetDto).collect(Collectors.toList());

        return (Page<SubCategoriaDTO>) FechasUtil.paginate(result, paginador, LstSubCategoriaEntity.getTotalElements());
    }

    @Override
    public List<SubCategoriaDTO> findAll() {
        List<SubCategoriaEntity> LstSubCategoriaEntity = subCategoriaRepository.findAll();
        return LstSubCategoriaEntity.stream().map(subCategoriaMapper::entityToGetDto).collect(Collectors.toList());
    }

    @Override
    public SubCategoriaDTO findById(UUID id) {
        SubCategoriaEntity categoria = this.subCategoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un registro para el ID suministrado."));
        return subCategoriaMapper.entityToGetDto(categoria);
    }

    @Override
    public SubCategoriaDTO save(SubCategoriaDTO subCategoriaDTO) {
        SubCategoriaEntity subCategoriaEntity = subCategoriaMapper.postDtoToEntity(subCategoriaDTO);
        var save = this.subCategoriaRepository.save(subCategoriaEntity);
        return subCategoriaMapper.entityToGetDto(save);
    }

    @Override
    public SubCategoriaDTO update(UUID id, SubCategoriaDTO subCategoriaDTO) {
        SubCategoriaEntity entity = this.subCategoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Caterogia no encontrado para este id :: " + id));
        SubCategoriaEntity updated = subCategoriaMapper.postDtoToEntity(subCategoriaDTO);
        if(updated.getNombre() != null){
            entity.setNombre(updated.getNombre());
        }
        if(updated.getUrl() != null){
            entity.setUrl(updated.getUrl());
        }
        if(updated.getImagen() != null){
            entity.setImagen(updated.getImagen());
        }
        if(updated.getInventario() != null){
            entity.setInventario(updated.getInventario());
        }
        if(updated.getVista() != null){
            entity.setVista(updated.getVista());
        }
        if(updated.getSubCategoriaTitulos() != null){
            entity.setSubCategoriaTitulos(updated.getSubCategoriaTitulos());
        }
        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(updated.getUsuarioCreacion());
        SubCategoriaEntity subCategoriaEntity = this.subCategoriaRepository.save(entity);
        return subCategoriaMapper.entityToGetDto(subCategoriaEntity);
    }

    @Override
    public Boolean delete(UUID id, SubCategoriaDTO subCategoriaDTO) {
        SubCategoriaEntity subCategoriaEntity = subCategoriaMapper.postDtoToEntity(subCategoriaDTO);
        subCategoriaEntity.setId(id);
        subCategoriaEntity.setFechaModificacion(LocalDateTime.now());
        subCategoriaEntity.setUsuarioModificacion(subCategoriaEntity.getUsuarioCreacion());
        this.subCategoriaRepository.save(subCategoriaEntity);
        return true;
    }
}
