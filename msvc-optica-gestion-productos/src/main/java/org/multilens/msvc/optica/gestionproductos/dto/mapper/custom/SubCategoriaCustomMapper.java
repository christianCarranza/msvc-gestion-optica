package org.multilens.msvc.optica.gestionproductos.dto.mapper.custom;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.SubCategoriaDTO;
import org.multilens.msvc.optica.gestionproductos.entity.SubCategoriaEntity;

@Mapper( uses = {SubCategoriaTituloCustomMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubCategoriaCustomMapper {

    SubCategoriaCustomMapper INSTANCE = Mappers.getMapper(SubCategoriaCustomMapper.class);

    SubCategoriaEntity postDtoToEntity(SubCategoriaDTO dto);

//    @Mapping(target = "subCategoriaTitulos", ignore = true)
    SubCategoriaDTO entityToGetDto(SubCategoriaEntity entity);


}
