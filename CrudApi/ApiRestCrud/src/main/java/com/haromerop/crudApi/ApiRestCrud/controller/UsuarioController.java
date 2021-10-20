package com.haromerop.crudApi.ApiRestCrud.controller;

import java.util.List;

import javax.validation.Valid;

import com.haromerop.crudApi.ApiRestCrud.dto.UsuarioRequest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.haromerop.crudApi.ApiRestCrud.exception.ApiUnprocessableEntity;
import com.haromerop.crudApi.ApiRestCrud.exception.ResourceNotFoundException;
import com.haromerop.crudApi.ApiRestCrud.model.Usuario;
import com.haromerop.crudApi.ApiRestCrud.service.UsuarioServiceImpl;
import com.haromerop.crudApi.ApiRestCrud.validator.UserValidatorImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Controlador de usuarios", tags = "Rest Api que Controla las acciones para consultar, crear, modificar y eliminar usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioServiceImpl usuarioService;
	private final UserValidatorImpl userValidator;
	private final MessageSource messageSource;

	public UsuarioController(UsuarioServiceImpl usuarioService, UserValidatorImpl userValidator, MessageSource messageSource) {
		this.usuarioService = usuarioService;
		this.userValidator = userValidator;
		this.messageSource = messageSource;
	}

	@ApiOperation(value = "Devuelve toda la lista de Base de Datos", response = ResponseEntity.class, tags = "Datos de todos los usuarios")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operación exitosa aquí están los usuarios registrados..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
			return ResponseEntity.ok(usuarioService.getAllUsuario());
	}
	
	@ApiOperation(value = "Devuelve un usuario en específico de la Base de Datos", response = ResponseEntity.class, tags = "Datos por el id del usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operación exitosa aquí está su usuario solicitado..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsuarioById(@PathVariable long id){
		try {
			return ResponseEntity.ok(usuarioService.getUsuarioById(id));						
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Crea usuarios en la Base de Datos", response = ResponseEntity.class, tags = "Crear un usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operación exitosa, usuario creado con éxito..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody UsuarioRequest usuario) throws ApiUnprocessableEntity{
		return ResponseEntity.ok().body(this.usuarioService.createUsuario(usuario));
	}
	
	@ApiOperation(value = "Actualiza los datos de un usuario específico en la Base de Datos", response = ResponseEntity.class, tags = "Actualizar un usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operación exitosa, usuario actualizado con éxito..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) throws ApiUnprocessableEntity{
		try {
			return ResponseEntity.ok().body(this.usuarioService.updateUsuario(usuarioRequest, id));
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}	
	
	@ApiOperation(value = "Elimina un usuario en específico en la Base de Datos", response = ResponseEntity.class, tags = "Eliminar un usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operación exitosa, usuario eliminado..."),
			@ApiResponse(code = 204, message = "No content..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable long id) throws ApiUnprocessableEntity{
		try {
			this.userValidator.validator(id);
			this.usuarioService.deleteUsuario(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Devuelve un saludo", response = ResponseEntity.class, tags = "Datos por el id del usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operación exitosa aquí está su usuario solicitado..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@GetMapping("/hi")
	public ResponseEntity<Object> getHello(){
		try {
			return ResponseEntity.ok(messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale()));
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
