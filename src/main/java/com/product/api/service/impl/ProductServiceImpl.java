package com.product.api.service.impl;

import java.util.Date;
import java.util.Optional;

import com.product.api.exceptions.EntityNotFoundException;
import com.product.api.models.dto.ProductDto;
import com.product.api.models.entities.ProductEntity;
import com.product.api.models.mapper.ProductMapper;
import com.product.api.repositories.ProductRepository;
import com.product.api.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	@Transactional
	public ProductDto save(ProductDto dto) {

		return ProductMapper.INSTANCE.entityToDto(repository.save(ProductMapper.INSTANCE.dtoToEntity(dto)));
	}

	@Override
	public ProductDto findById(Long id) throws EntityNotFoundException {

		Optional<ProductEntity> value = repository.findById(id);

		if (value.isPresent())

			return ProductMapper.INSTANCE.entityToDto(value.get());

		throw new EntityNotFoundException("producto no encontrado con id: " + id);

	}

	@Override
	@Transactional
	public ProductDto update(ProductDto dto) throws EntityNotFoundException {
		Optional<ProductEntity> value = repository.findById(dto.getId());

		dto.setModified(new Date());
		if (value.isPresent())

			return ProductMapper.INSTANCE.entityToDto(repository.save(ProductMapper.INSTANCE.dtoToEntity(dto)));

		throw new EntityNotFoundException("Producto no encontrado con id: " + dto.getId());

	}

	@Override
	public void delete(Long id) throws EntityNotFoundException {
		Optional<ProductEntity> value = repository.findById(id);

		if (value.isPresent()) {
			repository.deleteById(id);
		} else {

			throw new EntityNotFoundException("Producto no encontrado con id: " + id);
		}

	}

}
