package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.CategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.entity.CategoriaEntity;

@Mapper(uses = {SubCategoriaTituloMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaEntity postDtoToEntity(CategoriaDTO dto);

    CategoriaDTO entityToGetDto(CategoriaEntity entity);

}
