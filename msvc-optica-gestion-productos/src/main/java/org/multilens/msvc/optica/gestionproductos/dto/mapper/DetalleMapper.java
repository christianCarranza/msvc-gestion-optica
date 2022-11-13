package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.DetalleDTO;
import org.multilens.msvc.optica.gestionproductos.entity.DetalleEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DetalleMapper {

    DetalleMapper INSTANCE = Mappers.getMapper(DetalleMapper.class);

    DetalleDTO postDtoToEntity(DetalleEntity entity);

    DetalleEntity entityToGetDto(DetalleDTO dto);

}
