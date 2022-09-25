package org.multilens.msvc.optica.gestionproductos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.multilens.msvc.optica.gestionproductos.dto.ProductoDTO;
import org.multilens.msvc.optica.gestionproductos.entity.ProductoEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    ProductoEntity postDtoToEntity(ProductoDTO dto);

    ProductoDTO entityToGetDto(ProductoEntity entity);

}
