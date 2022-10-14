package org.multilens.msvc.optica.gestionproductos.service.Impl;

import org.multilens.msvc.optica.gestionproductos.dto.CategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.CategoriaMapper;
import org.multilens.msvc.optica.gestionproductos.entity.CategoriaEntity;
import org.multilens.msvc.optica.gestionproductos.exception.NotFoundException;
import org.multilens.msvc.optica.gestionproductos.repository.CategoriaRepository;
import org.multilens.msvc.optica.gestionproductos.repository.SubCategoriaTituloRepository;
import org.multilens.msvc.optica.gestionproductos.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private final CategoriaRepository categoriaRepository;
    private final SubCategoriaTituloRepository subCategoriaTituloRepository;

    private static final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, SubCategoriaTituloRepository subCategoriaTituloRepository) {
        this.categoriaRepository = categoriaRepository;
        this.subCategoriaTituloRepository = subCategoriaTituloRepository;
    }


    @Override
    public List<CategoriaDTO> findAll() {
        var lstCategoriaEntity = categoriaRepository.findAll();

        
        return lstCategoriaEntity.stream().map(categoriaMapper::entityToGetDto).collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO findById(UUID id) {

        CategoriaEntity categoria = this.categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un registro para el ID suministrado."));

        return categoriaMapper.entityToGetDto(categoria);
    }

    @Override
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        var categoriaEntity = categoriaMapper.postDtoToEntity(categoriaDTO);
        var save = this.categoriaRepository.save(categoriaEntity);
        return categoriaMapper.entityToGetDto(save);
    }

    @Override
    public CategoriaDTO update(UUID id, CategoriaDTO categoriaDTO) {
        CategoriaEntity entity = this.categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Caterogia no encontrado para este id :: " + id));
        CategoriaEntity updated = categoriaMapper.postDtoToEntity(categoriaDTO);
        if(updated.getNombre() != null){
            entity.setNombre(updated.getNombre());
        }
        if(updated.getUrl() != null){
            entity.setUrl(updated.getUrl());
        }
        if(updated.getImagen() != null){
            entity.setImagen(updated.getImagen());
        }
        if(updated.getIcono() != null){
            entity.setIcono(updated.getIcono());
        }
        if(updated.getVista() != null){
            entity.setVista(updated.getVista());
        }
        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(updated.getUsuarioCreacion());
        categoriaRepository.save(entity);
        return categoriaMapper.entityToGetDto(entity);
    }

    @Override
    public void delete(UUID id, Integer estado) {
        CategoriaEntity entity = this.categoriaRepository.findById(id).orElseThrow(RuntimeException::new);
        entity.setEstado(estado); // 0 = Inactivo, 1 = Activo
        this.categoriaRepository.save(entity);
    }
}
