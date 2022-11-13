package org.multilens.msvc.optica.gestionproductos.dto.mapper.custom;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.GaleriaDTO;
import org.multilens.msvc.optica.gestionproductos.entity.GaleriaEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GaleriaCustomMapper {

    GaleriaCustomMapper INSTANCE = Mappers.getMapper(GaleriaCustomMapper.class);

    @Mapping(target = "producto", ignore = true)
    GaleriaDTO postDtoToEntity(GaleriaEntity entity);

    @Mapping(target = "producto", ignore = true)
    GaleriaEntity entityToGetDto(GaleriaDTO dto);

}
