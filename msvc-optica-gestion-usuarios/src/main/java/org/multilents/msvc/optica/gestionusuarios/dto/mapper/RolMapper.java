package org.multilents.msvc.optica.gestionusuarios.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilents.msvc.optica.gestionusuarios.dto.RolDTO;
import org.multilents.msvc.optica.gestionusuarios.entity.RolEntity;

@Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolEntity postDtoToEntity(RolDTO dto);

    RolDTO entityToGetDto(RolEntity entity);
}
