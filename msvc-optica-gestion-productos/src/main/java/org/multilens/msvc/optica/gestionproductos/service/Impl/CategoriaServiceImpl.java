package org.multilens.msvc.optica.gestionproductos.service.Impl;

import org.multilens.msvc.optica.gestionproductos.dto.CategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.CategoriaMapper;
import org.multilens.msvc.optica.gestionproductos.repository.CategoriaRepository;
import org.multilens.msvc.optica.gestionproductos.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl  implements CategoriaService {


    private final CategoriaRepository categoriaRepository;

    private static final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public List<CategoriaDTO> findByLike(CategoriaDTO categoriaDTO) {
        var lstCategoriaEntity = categoriaRepository.findAll();
        return lstCategoriaEntity.stream().map(categoriaMapper::entityToGetDto).collect(Collectors.toList());
    }

    @Override
    public Optional<CategoriaDTO> findById(Long id) {
        return Optional.empty();
    }
}
