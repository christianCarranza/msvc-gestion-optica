package org.multilens.msvc.optica.gestionproductos.dto.mapper.custom;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.SubCategoriaTituloDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.SubCategoriaTituloMapper;
import org.multilens.msvc.optica.gestionproductos.entity.SubCategoriaTituloEntity;

@Mapper(uses = {CategoriaCustomMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubCategoriaTituloCustomMapper {

    SubCategoriaTituloMapper INSTANCE = Mappers.getMapper(SubCategoriaTituloMapper.class);

    SubCategoriaTituloEntity postDtoToEntity(SubCategoriaTituloDTO dto);

    SubCategoriaTituloDTO entityToGetDto(SubCategoriaTituloEntity entity);

}
