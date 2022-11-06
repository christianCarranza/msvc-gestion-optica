package org.multilents.msvc.optica.msvcopticagestionventas.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.VentaDTO;
import org.multilents.msvc.optica.msvcopticagestionventas.entity.VentaEntity;

@Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VentaMapper {

    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

    @Mapping(target = "producto", ignore = true)
    VentaEntity postDtoToEntity(VentaDTO dto);

    @Mapping(target = "producto", ignore = true)
    VentaDTO entityToGetDto(VentaEntity entity);
}
