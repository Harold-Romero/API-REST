package com.haromerop.crudApi.ApiRestCrud.validator;

import org.springframework.stereotype.Service;

import com.haromerop.crudApi.ApiRestCrud.exception.ApiUnprocessableEntity;
import com.haromerop.crudApi.ApiRestCrud.model.Usuario;

/**
 * Interface para la validación de datos recibidos para la creación de usuarios
 * @author Harold Romero
 *
 */

@Service
public interface UsuarioValidator {
	
	void validator(Usuario usuario) throws ApiUnprocessableEntity;
}
