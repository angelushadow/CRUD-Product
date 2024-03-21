package com.product.api.models.mapper;

import java.util.List;

import com.product.api.models.dto.ProductDto;
import com.product.api.models.entities.ProductEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	ProductDto entityToDto (ProductEntity entity);

	ProductEntity dtoToEntity(ProductDto dto);

	List<ProductDto> dtoToEntity(List<ProductEntity> listEntity);

	List<ProductEntity> entityToDto(List<ProductDto> dto);
	
}	
