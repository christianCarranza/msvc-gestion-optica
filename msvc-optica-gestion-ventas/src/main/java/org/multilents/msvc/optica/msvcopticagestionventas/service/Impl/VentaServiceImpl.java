package org.multilents.msvc.optica.msvcopticagestionventas.service.Impl;


import org.multilents.msvc.optica.msvcopticagestionventas.dto.VentaDTO;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.mapper.VentaMapper;
import org.multilents.msvc.optica.msvcopticagestionventas.entity.VentaEntity;
import org.multilents.msvc.optica.msvcopticagestionventas.exception.NotFoundException;
import org.multilents.msvc.optica.msvcopticagestionventas.repository.VentaRepository;
import org.multilents.msvc.optica.msvcopticagestionventas.service.VentaService;
import org.multilents.msvc.optica.msvcopticagestionventas.service.client.service.ProductoService;
import org.multilents.msvc.optica.msvcopticagestionventas.utils.FechasUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {
    private final VentaRepository ventaRepository;
    private final ProductoService productoService;

    private static final VentaMapper ventaMapper = VentaMapper.INSTANCE;

    public VentaServiceImpl(VentaRepository ventaRepository, ProductoService productoService) {
        this.ventaRepository = ventaRepository;
        this.productoService = productoService;
    }


    @Override
    public Page<VentaDTO> findAllPage(Pageable paginador) {
        Page<VentaEntity> lstVentaEntity = ventaRepository.findAllPage(paginador);
        List<VentaDTO>  result = lstVentaEntity.stream().map(ventaMapper::entityToGetDto).collect(Collectors.toList());

        return (Page<VentaDTO>) FechasUtil.paginate(result, paginador, lstVentaEntity.getTotalElements());
    }

    @Override
    public Page<VentaDTO> findByProducto(UUID productoId, Pageable pageable) {
        Page<VentaEntity> lstVentaEntity = ventaRepository.findByProducto(productoId, pageable);
        List<VentaDTO>  result = lstVentaEntity.stream().map(ventaMapper::entityToGetDto).collect(Collectors.toList());
        return (Page<VentaDTO>) FechasUtil.paginate(result, pageable, lstVentaEntity.getTotalElements());
    }

    @Override
    public Page<VentaDTO> findByCliente(UUID clienteId, Pageable pageable) {
        Page<VentaEntity> lstVentaEntity = ventaRepository.findByCliente(clienteId, pageable);
        List<VentaDTO>  result = lstVentaEntity.stream().map(ventaMapper::entityToGetDto).collect(Collectors.toList());
        return (Page<VentaDTO>) FechasUtil.paginate(result, pageable, lstVentaEntity.getTotalElements());
    }

    @Override
    public List<VentaDTO> findAll() {
        var lstVentaEntity = ventaRepository.findAll();
        return lstVentaEntity.stream().map(ventaMapper::entityToGetDto).collect(Collectors.toList());
    }

    @Override
    public VentaDTO findById(UUID id) {
        VentaEntity venta = this.ventaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un registro para el ID suministrado."));

        VentaDTO ventaDTO = ventaMapper.entityToGetDto(venta);
        if (!Objects.isNull(ventaDTO)) {
            ventaDTO.setProducto(productoService.findById(venta.getCliente()));
        }
        return ventaDTO;
    }

    @Override
    public VentaDTO save(VentaDTO ventaDTO) {
        var ventaEntity = ventaMapper.postDtoToEntity(ventaDTO);
        var save = this.ventaRepository.save(ventaEntity);
        return ventaMapper.entityToGetDto(save);
    }

    @Override
    public VentaDTO update(UUID id, VentaDTO ventaDTO) {
        VentaEntity entity = this.ventaRepository.findById(id).orElseThrow(() -> new NotFoundException("Caterogia no encontrado para este id :: " + id));
        VentaEntity updated = ventaMapper.postDtoToEntity(ventaDTO);
        if(updated.getProducto() != null){
            entity.setProducto(updated.getProducto());
        }
        if(updated.getCliente() != null){
            entity.setCliente(updated.getCliente());
        }
        if(updated.getEstadoVenta() != null){
            entity.setEstadoVenta(updated.getEstadoVenta());
        }
        if(updated.getCantidad() != null){
            entity.setCantidad(updated.getCantidad());
        }
        if(updated.getPrecioTotal() != null){
            entity.setPrecioTotal(updated.getPrecioTotal());
        }
        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(updated.getUsuarioModificacion());
        ventaRepository.save(entity);
        return ventaMapper.entityToGetDto(entity);
    }

    @Override
    public Boolean delete(UUID id, VentaDTO ventaDTO) {
        VentaEntity entity = this.ventaRepository.findById(id).orElseThrow(RuntimeException::new);
        entity.setFechaModificacion(LocalDateTime.now());
        entity.setUsuarioModificacion(ventaDTO.getUsuarioModificacion());
        entity.setEstado(ventaDTO.getEstado()); // 0 = Inactivo, 1 = Activo
        this.ventaRepository.save(entity);
        return true;
    }

}
