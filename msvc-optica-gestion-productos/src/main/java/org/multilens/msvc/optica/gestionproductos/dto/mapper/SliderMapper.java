package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.SliderDTO;
import org.multilens.msvc.optica.gestionproductos.entity.SliderEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SliderMapper {

    SliderMapper INSTANCE = Mappers.getMapper(SliderMapper.class);

    SliderDTO postDtoToEntity(SliderEntity entity);

    SliderEntity entityToGetDto(SliderDTO dto);

}
