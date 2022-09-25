package org.multilens.msvc.optica.gestionproductos.service.service.Impl;


import org.springframework.stereotype.Service;
import org.multilens.msvc.optica.gestionproductos.dto.ProductoDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.ProductoMapper;
import org.multilens.msvc.optica.gestionproductos.repository.ProductoRepository;
import org.multilens.msvc.optica.gestionproductos.service.exception.ServiceException;
import org.multilens.msvc.optica.gestionproductos.service.service.ProductoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    private static final ProductoMapper productoMapper = ProductoMapper.INSTANCE;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoDTO> findByLike(ProductoDTO productoDTO) throws ServiceException {
        try {
            var lstProductoEntity = productoRepository.findAll();

            return lstProductoEntity.stream().map(productoMapper::entityToGetDto).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<ProductoDTO> findById(Long id) throws ServiceException {
        return Optional.empty();
    }
}
