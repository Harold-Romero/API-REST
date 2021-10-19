package com.haromerop.crudApi.ApiRestCrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * Excepcion personalizada de status 422
 * @author Harold Romero
 *
 */

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ApiUnprocessableEntity(String message) {
		super(message);
	}
	
	
}
