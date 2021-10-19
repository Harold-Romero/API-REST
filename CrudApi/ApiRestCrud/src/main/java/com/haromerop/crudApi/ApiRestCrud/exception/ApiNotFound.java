package com.haromerop.crudApi.ApiRestCrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepcion personalizada de status 404
 * @author Harold Romero
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ApiNotFound(String message) {
		super(message);
	}
}
