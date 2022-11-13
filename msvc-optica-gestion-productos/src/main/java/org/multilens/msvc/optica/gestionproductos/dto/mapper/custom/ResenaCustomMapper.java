package org.multilens.msvc.optica.gestionproductos.dto.mapper.custom;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.ResenaDTO;
import org.multilens.msvc.optica.gestionproductos.entity.ResenaEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResenaCustomMapper {

    ResenaCustomMapper INSTANCE = Mappers.getMapper(ResenaCustomMapper.class);

    @Mapping(target = "producto", ignore = true)
    ResenaDTO postDtoToEntity(ResenaEntity entity);

    @Mapping(target = "producto", ignore = true)
    ResenaEntity entityToGetDto(ResenaDTO dto);

}
