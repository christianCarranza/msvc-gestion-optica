package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.GaleriaDTO;
import org.multilens.msvc.optica.gestionproductos.entity.GaleriaEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GaleriaMapper {

    GaleriaMapper INSTANCE = Mappers.getMapper(GaleriaMapper.class);

    GaleriaDTO postDtoToEntity(GaleriaEntity entity);

    GaleriaEntity entityToGetDto(GaleriaDTO dto);

}
