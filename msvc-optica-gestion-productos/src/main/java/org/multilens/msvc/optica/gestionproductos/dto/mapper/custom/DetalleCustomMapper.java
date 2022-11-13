package org.multilens.msvc.optica.gestionproductos.dto.mapper.custom;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.DetalleDTO;
import org.multilens.msvc.optica.gestionproductos.entity.DetalleEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DetalleCustomMapper {

    DetalleCustomMapper INSTANCE = Mappers.getMapper(DetalleCustomMapper.class);

    @Mapping(target = "producto", ignore = true)
    DetalleDTO postDtoToEntity(DetalleEntity entity);

    @Mapping(target = "producto", ignore = true)
    DetalleEntity entityToGetDto(DetalleDTO dto);

}
