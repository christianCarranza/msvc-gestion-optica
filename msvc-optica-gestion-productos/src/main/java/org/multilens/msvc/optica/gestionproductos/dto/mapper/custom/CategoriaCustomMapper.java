package org.multilens.msvc.optica.gestionproductos.dto.mapper.custom;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.CategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.CategoriaMapper;
import org.multilens.msvc.optica.gestionproductos.entity.CategoriaEntity;

@Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaCustomMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaEntity postDtoToEntity(CategoriaDTO dto);

    @Mapping(target = "subCategoriaTitulo", ignore = true)
    CategoriaDTO entityToGetDto(CategoriaEntity entity);

}
