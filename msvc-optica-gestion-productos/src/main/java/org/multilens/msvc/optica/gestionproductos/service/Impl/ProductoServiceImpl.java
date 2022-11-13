package org.multilens.msvc.optica.gestionproductos.service.Impl;

import org.multilens.msvc.optica.gestionproductos.dto.ProductoDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.*;
import org.multilens.msvc.optica.gestionproductos.entity.ProductoEntity;
import org.multilens.msvc.optica.gestionproductos.exception.NotFoundException;
import org.multilens.msvc.optica.gestionproductos.repository.*;
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
    private final ResenaRepository resenaRepository;
    private final DetalleRepository detalleRepository;
    private final GaleriaRepository galeriaRepository;
    private final SliderRepository sliderRepository;
    private final BannerRepository bannerRepository;
    private final PromocionRepository promocionRepository;

    private static final ProductoMapper productoMapper = ProductoMapper.INSTANCE;
    private static final GaleriaMapper galeriaMapper = GaleriaMapper.INSTANCE.INSTANCE;
    private static final DetalleMapper detalleMapper = DetalleMapper.INSTANCE;
    private static final ResenaMapper resenaMapper = ResenaMapper.INSTANCE;
    private static final SliderMapper sliderMapper = SliderMapper.INSTANCE;
    private static final BannerMapper bannerMapper = BannerMapper.INSTANCE;
    private static final PromocionMapper promocionMapper = PromocionMapper.INSTANCE;

    public ProductoServiceImpl(org.multilens.msvc.optica.gestionproductos.repository.ProductoRepository productoRepository, ResenaRepository resenaRepository, DetalleRepository detalleRepository, GaleriaRepository galeriaRepository, SliderRepository sliderRepository, BannerRepository bannerRepository, PromocionRepository promocionRepository) {
        ProductoRepository = productoRepository;
        this.resenaRepository = resenaRepository;
        this.detalleRepository = detalleRepository;
        this.galeriaRepository = galeriaRepository;
        this.sliderRepository = sliderRepository;
        this.bannerRepository = bannerRepository;
        this.promocionRepository = promocionRepository;
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

        var galery = productoDTO.getGaleria();
        var resen = productoDTO.getResena();
        var deta = productoDTO.getDetalle();
        productoDTO.setGaleria(null);
        productoDTO.setResena(null);
        productoDTO.setDetalle(null);

        var productoEntity = productoMapper.postDtoToEntity(productoDTO);
        var slide = this.sliderRepository.save(productoEntity.getSlider());
        var ban = this.bannerRepository.save(productoEntity.getTopBanner());
        var promo = this.promocionRepository.save(productoEntity.getPromocion());
        productoEntity.setSlider(slide);
        productoEntity.setTopBanner(ban);
        productoEntity.setPromocion(promo);

        var save = this.ProductoRepository.save(productoEntity);
        var dto = productoMapper.entityToGetDto(save);


        ProductoDTO productoDTO1 = new ProductoDTO();
        productoDTO1.setId(save.getId());

        if(!galery.isEmpty()){
            galery.forEach(gal -> {
                gal.setProducto(productoDTO1);
            });
            var galeryEntity = galery.stream().map(galeriaMapper::entityToGetDto).collect(Collectors.toList());
            var saveGalery = this.galeriaRepository.saveAll(galeryEntity);
        }
        if (!resen.isEmpty()) {
            resen.forEach(res -> {
                res.setProducto(dto);
            });
            var resenEntity = resen.stream().map(resenaMapper::entityToGetDto).collect(Collectors.toList());
            var saveResen = this.resenaRepository.saveAll(resenEntity);
        }
        if (!deta.isEmpty()) {
            deta.forEach(det -> {
                det.setProducto(productoDTO1);
            });
            var detaEntity = deta.stream().map(detalleMapper::entityToGetDto).collect(Collectors.toList());
            var saveDeta = this.detalleRepository.saveAll(detaEntity);
        }

        dto.setGaleria(galery);
        dto.setResena(resen);
        dto.setDetalle(deta);


        return dto;
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
    public Page<ProductoDTO> findAllPageActive(Pageable paginador) {
        Page<ProductoEntity> lstProductoEntity = ProductoRepository.findAllPageActive(paginador);
        List<ProductoDTO> result = lstProductoEntity.stream().map(productoMapper::entityToGetDto).collect(Collectors.toList());

        return (Page<ProductoDTO>) FechasUtil.paginate(result, paginador, lstProductoEntity.getTotalElements());
    }

    @Override
    public List<ProductoDTO> findByLikeNombre(String nombre) {
        Optional<ProductoEntity> lstProductoEntity = this.ProductoRepository.findByLikeNombre(nombre);
        return lstProductoEntity.stream().map(productoMapper::entityToGetDto).collect(Collectors.toList());
    }
}
