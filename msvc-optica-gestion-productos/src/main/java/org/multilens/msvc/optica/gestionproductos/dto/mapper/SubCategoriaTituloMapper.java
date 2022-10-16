package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.SubCategoriaTituloDTO;
import org.multilens.msvc.optica.gestionproductos.entity.SubCategoriaTituloEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubCategoriaTituloMapper {

    SubCategoriaTituloMapper INSTANCE = Mappers.getMapper(SubCategoriaTituloMapper.class);

    SubCategoriaTituloEntity postDtoToEntity(SubCategoriaTituloDTO dto);

    @Mapping(target = "categoria", ignore = true)
    SubCategoriaTituloDTO entityToGetDto(SubCategoriaTituloEntity entity);

}
