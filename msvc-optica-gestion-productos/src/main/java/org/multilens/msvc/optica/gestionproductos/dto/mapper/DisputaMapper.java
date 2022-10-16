package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.DisputaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.DisputaDTO;
import org.multilens.msvc.optica.gestionproductos.entity.DisputaEntity;
import org.multilens.msvc.optica.gestionproductos.entity.DisputaEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DisputaMapper {

    DisputaMapper INSTANCE = Mappers.getMapper(DisputaMapper.class);

    DisputaEntity postDtoToEntity(DisputaDTO dto);

    DisputaDTO entityToGetDto(DisputaEntity entity);

}
