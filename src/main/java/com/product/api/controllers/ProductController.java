package com.product.api.controllers;

import com.product.api.models.dto.ProductDto;
import com.product.api.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Product", description = "Crud de Productos Api")
@RestController
public class ProductController {

	public static final String URL_RESOURCE = "/product";
	public static final String URL_ID_PATH = "/{id}";

	@Autowired
	private ProductService service;

	@PostMapping(URL_RESOURCE)
	@Operation(summary = "Crear nuevo producto", description = "Crea un producto nuevo en la base de datos")
	public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto dto) {
		return ResponseEntity.ok().body(service.save(dto));
	}

	@PutMapping(URL_RESOURCE)
	@Operation(summary = "Actualizar producto", description = "Actualiza un producto de la base de datos")
	public ResponseEntity<ProductDto> update(@Valid @RequestBody ProductDto dto) {
		return ResponseEntity.ok().body(service.update(dto));
	}

	@GetMapping(URL_RESOURCE + URL_ID_PATH)
	@Operation(summary = "Encontrar un producto por Id", description = "Encuentra un producto en la base de datos por el Id de tipo long")
	public ResponseEntity<ProductDto> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok().body(service.findById(id));

	}

	@DeleteMapping(URL_RESOURCE + URL_ID_PATH)
	@Operation(summary = "Eliminar un producto por Id", description = "Elimina un producto de la base de datos por el Id de tipo long")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
