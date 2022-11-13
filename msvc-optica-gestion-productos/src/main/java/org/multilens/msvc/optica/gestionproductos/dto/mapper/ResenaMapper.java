package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.ResenaDTO;
import org.multilens.msvc.optica.gestionproductos.entity.ResenaEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResenaMapper {

    ResenaMapper INSTANCE = Mappers.getMapper(ResenaMapper.class);

    ResenaDTO postDtoToEntity(ResenaEntity entity);

    ResenaEntity entityToGetDto(ResenaDTO dto);

}
