package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.PromocionDTO;
import org.multilens.msvc.optica.gestionproductos.entity.PromocionEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PromocionMapper {

    PromocionMapper INSTANCE = Mappers.getMapper(PromocionMapper.class);

    PromocionDTO postDtoToEntity(PromocionEntity entity);

    PromocionEntity entityToGetDto(PromocionDTO dto);

}
