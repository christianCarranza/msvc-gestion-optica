package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.SubCategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.dto.mapper.custom.SubCategoriaTituloCustomMapper;
import org.multilens.msvc.optica.gestionproductos.entity.SubCategoriaEntity;

@Mapper(uses = {SubCategoriaTituloCustomMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubCategoriaMapper {

    SubCategoriaMapper INSTANCE = Mappers.getMapper(SubCategoriaMapper.class);

    SubCategoriaEntity postDtoToEntity(SubCategoriaDTO dto);

    SubCategoriaDTO entityToGetDto(SubCategoriaEntity entity);

}
