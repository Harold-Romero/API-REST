package com.haromerop.crudApi.ApiRestCrud.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haromerop.crudApi.ApiRestCrud.dto.UserLoginRequest;
import com.haromerop.crudApi.ApiRestCrud.exception.ApiUnprocessableEntity;
import com.haromerop.crudApi.ApiRestCrud.model.UserLogin;
import com.haromerop.crudApi.ApiRestCrud.service.UserLoginService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/create_login")
public class UserLoginController {
	
	private UserLoginService userLoginService;
	
	@ApiOperation(value = "Crea usuarios en la Base de Datos", response = ResponseEntity.class, tags = "Crear un usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operación exitosa, usuario creado con éxito..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@PostMapping
	public ResponseEntity<UserLogin> createUsuario(@Valid @RequestBody UserLoginRequest userLogin) throws ApiUnprocessableEntity{
		return ResponseEntity.ok().body(this.userLoginService.createUser(userLogin));
	}
}
