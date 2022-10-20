package org.multilents.msvc.optica.msvcopticagestionventas.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilents.msvc.optica.msvcopticagestionventas.dto.ProcesoDTO;
import org.multilents.msvc.optica.msvcopticagestionventas.entity.ProcesoEntity;

@Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProcesoMapper {

    ProcesoMapper INSTANCE = Mappers.getMapper(ProcesoMapper.class);

    ProcesoEntity postDtoToEntity(ProcesoDTO dto);

    ProcesoDTO entityToGetDto(ProcesoEntity entity);

}
