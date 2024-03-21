package com.product.api.service;

import com.product.api.exceptions.EntityNotFoundException;
import com.product.api.models.dto.ProductDto;

public interface ProductService {

	ProductDto save(ProductDto dto);

	ProductDto findById(Long id) throws EntityNotFoundException;

	ProductDto update(ProductDto dto) throws EntityNotFoundException;

	void delete(Long id) throws EntityNotFoundException;

}
