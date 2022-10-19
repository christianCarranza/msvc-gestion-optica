package org.multilents.msvc.optica.gestionusuarios.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilents.msvc.optica.gestionusuarios.dto.UsuarioDTO;
import org.multilents.msvc.optica.gestionusuarios.entity.UsuarioEntity;

@Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioEntity postDtoToEntity(UsuarioDTO dto);

    UsuarioDTO entityToGetDto(UsuarioEntity entity);

}
