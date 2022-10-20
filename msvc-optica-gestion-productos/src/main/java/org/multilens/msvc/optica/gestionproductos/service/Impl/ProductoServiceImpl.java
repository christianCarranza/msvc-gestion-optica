package org.multilens.msvc.optica.gestionproductos.service.Impl;

import org.multilens.msvc.optica.gestionproductos.dto.ProductoDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.ProductoMapper;
import org.multilens.msvc.optica.gestionproductos.entity.ProductoEntity;
import org.multilens.msvc.optica.gestionproductos.exception.NotFoundException;
import org.multilens.msvc.optica.gestionproductos.repository.ProductoRepository;
import org.multilens.msvc.optica.gestionproductos.service.ProductoService;
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
public class ProductoServiceImpl  implements ProductoService {

    private final ProductoRepository ProductoRepository;

    private static final ProductoMapper productoMapper = ProductoMapper.INSTANCE;

    public ProductoServiceImpl(org.multilens.msvc.optica.gestionproductos.repository.ProductoRepository productoRepository) {
        ProductoRepository = productoRepository;
    }


    @Override
    public Page<ProductoDTO> findAllPage(Pageable paginador) {
        Page<ProductoEntity> lstProductoEntity = ProductoRepository.findAllPage(paginador);
        List<ProductoDTO> result = lstProductoEntity.stream().map(productoMapper::entityToGetDto).collect(Collectors.toList());

        return (Page<ProductoDTO>) FechasUtil.paginate(result, paginador, lstProductoEntity.getTotalElements());
    }

    @Override
    public List<ProductoDTO> findAll() {
        var lstProductoEntity = ProductoRepository.findAll();


        return lstProductoEntity.stream().map(productoMapper::entityToGetDto).collect(Collectors.toList());
    }

    @Override
    public ProductoDTO findById(UUID id) {

        ProductoEntity producto = this.ProductoRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un registro para el ID suministrado."));

        return productoMapper.entityToGetDto(producto);
    }

    @Override
    public ProductoDTO findByIdActive(UUID id) {

        ProductoEntity producto = this.ProductoRepository.findByIdActive(id);
        if(producto.getId() == null){
            throw new NotFoundException("No existe un registro para el ID suministrado.");
        }
        return productoMapper.entityToGetDto(producto);
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        var productoEntity = productoMapper.postDtoToEntity(productoDTO);
        var save = this.ProductoRepository.save(productoEntity);



        return productoMapper.entityToGetDto(save);
    }

    @Override
    public ProductoDTO update(UUID id, ProductoDTO productoDTO) {
        ProductoEntity entity = this.ProductoRepository.findById(id).orElseThrow(() -> new NotFoundException("Caterogia no encontrado para este id :: " + id));
        ProductoEntity updated = productoMapper.postDtoToEntity(productoDTO);
        if(updated.getSubCategoria() != null){
            entity.setSubCategoria(updated.getSubCategoria());
        }
        if(updated.getNombre() != null){
            entity.setNombre(updated.getNombre());
        }
        if(updated.getPalabraClave() != null){
            entity.setPalabraClave(updated.getPalabraClave());
        }
        if(updated.getUrl() != null){
            entity.setUrl(updated.getUrl());
        }
        if(updated.getImagen() != null){
            entity.setImagen(updated.getImagen());
        }
        if(updated.getPrecio() != null){
            entity.setPrecio(updated.getPrecio());
        }
        if(updated.getStock() != null){
            entity.setStock(updated.getStock());
        }
        if(updated.getCupon() != null){
            entity.setCupon(updated.getCupon());
        }
        if(updated.getTopBanner() != null){
            entity.setTopBanner(updated.getTopBanner());
        }
        if(updated.getSlider() != null){
            entity.setSlider(updated.getSlider());
        }
        if(updated.getEspecificaciones() != null){
            entity.setEspecificaciones(updated.getEspecificaciones());
        }
        if(updated.getDetalles() != null){
            entity.setDetalles(updated.getDetalles());
        }
        if(updated.getDescripcion() != null){
            entity.setDescripcion(updated.getDescripcion());
        }
        if(updated.getDefaultBanner() != null){
            entity.setDefaultBanner(updated.getDefaultBanner());
        }
        if(updated.getVerticalSlider() != null){
            entity.setVerticalSlider(updated.getVerticalSlider());
        }

        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(updated.getUsuarioCreacion());
        ProductoRepository.save(entity);
        return productoMapper.entityToGetDto(entity);
    }

    @Override
    public Boolean delete(UUID id, ProductoDTO productoDTO) {
        ProductoEntity entity = this.ProductoRepository.findById(id).orElseThrow(RuntimeException::new);
        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(productoDTO.getUsuarioCreacion());
        entity.setEstado(productoDTO.getEstado()); // 0 = Inactivo, 1 = Activo
        this.ProductoRepository.save(entity);
        return true;
    }

    @Override
    public List<ProductoDTO> findByLikeNombre(String nombre) {
        Optional<ProductoEntity> lstProductoEntity = this.ProductoRepository.findByLikeNombre(nombre);
        return lstProductoEntity.stream().map(productoMapper::entityToGetDto).collect(Collectors.toList());
    }
}
