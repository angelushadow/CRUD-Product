package com.product.api.controllers;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.api.models.dto.ProductDto;
import com.product.api.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductService serviceTest;

	ObjectMapper mapper;

	@BeforeEach
	void setup() {
		mapper = new ObjectMapper();
	}

	@Test
	@DisplayName("POST , Prueba para guardar un producto")
	void saveTest() throws Exception {
		// Given
		ProductDto dto = ProductDto.builder().nombre("Producto de Prueba").precio(1037).build();

		when(serviceTest.save(any())).then(invocation -> {
			ProductDto p = invocation.getArgument(0);
			p.setId(2L);
			return p;
		});

		// when
		mvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
				// Then
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(2))).andExpect(jsonPath("$.nombre", is(dto.getNombre())))
				.andExpect(jsonPath("$.precio", is(dto.getPrecio())));
		verify(serviceTest).save(any());

	}

	@Test
	@DisplayName("GET, Prueba para el buscar por el identificador de un producto")
	void findByIdTest() throws Exception {
		// Given
		long id = 1L;
		ProductDto dto = ProductDto.builder().id(id).nombre("Producto de Prueba").precio(1037).build();

		when(serviceTest.findById(id)).thenReturn(productCreate().orElseThrow());

		// When
		mvc.perform(get("/product/1").contentType(MediaType.APPLICATION_JSON))
				// Then
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.nombre").value(dto.getNombre()))
				.andExpect(jsonPath("$.precio").value(dto.getPrecio()));

		verify(serviceTest).findById(1L);
	}

	@Test
	@DisplayName("PUT, Prueba para actualizar un registro de la base de datos")
	void updateTest() throws Exception {
		// Given
		long id = 1L;
		ProductDto dto = ProductDto.builder().id(id).nombre("Producto de Prueba").precio(1037).created(new Date())
				.build();

		// When
		when(serviceTest.update(any())).then(invocation -> {
			ProductDto p = invocation.getArgument(0);
			p.setModified(new Date());
			return p;
		});

		mvc.perform(put("/product").content(mapper.writeValueAsString(dto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	private static Optional<ProductDto> productCreate() {
		return Optional
				.of(ProductDto.builder().id(1L).nombre("Producto de Prueba").precio(1037).created(new Date()).build());
	}

}
