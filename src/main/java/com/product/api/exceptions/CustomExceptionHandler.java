package com.product.api.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("unchecked")
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(EntityNotFoundException ex, WebRequest request) {
		return new ResponseEntity(ErrorResponseDto.builder().mensaje(ex.getMessage()).build(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ValidateException.class)
	public final ResponseEntity<Object> handleValidationException(ValidateException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		ErrorResponseDto error = new ErrorResponseDto(ex.getMessage() + details.toString());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}


}
