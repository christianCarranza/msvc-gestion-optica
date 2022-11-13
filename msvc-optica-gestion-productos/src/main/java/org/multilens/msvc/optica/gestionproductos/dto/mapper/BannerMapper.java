package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.BannerDTO;
import org.multilens.msvc.optica.gestionproductos.entity.BannerEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BannerMapper {

    BannerMapper INSTANCE = Mappers.getMapper(BannerMapper.class);

    BannerDTO postDtoToEntity(BannerEntity entity);

    BannerEntity entityToGetDto(BannerDTO dto);

}
