package com.product.api.models.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
	
	private Long id;
	
	@NotBlank(message = "nombre es requerido")
	private String nombre;
	
	@Min(value = 1, message = "precio es requerido")
	private Integer precio;
	
	private Date created;
	private Date modified;

}
