package com.haromerop.crudApi.ApiRestCrud.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.haromerop.crudApi.ApiRestCrud.exception.ApiUnprocessableEntity;
import com.haromerop.crudApi.ApiRestCrud.exception.ResourceNotFoundException;
import com.haromerop.crudApi.ApiRestCrud.model.Usuario;
import com.haromerop.crudApi.ApiRestCrud.service.UsuarioServiceImpl;
import com.haromerop.crudApi.ApiRestCrud.validator.UserValidatorImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Controlador de usuarios", description ="Rest Api que Controla las acciones para consultar, crear, modificar y eliminar usuarios")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	@Autowired
	private UserValidatorImpl userValidator;
	
	@ApiOperation(value = "Devuelve toda la lista de Base de Datos", response = Iterable.class, tags = "Datos de todos los usuarios")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operacion exitosa aquí están los usuarios registrados..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
			return ResponseEntity.ok(usuarioService.getAllUsuario());
	}
	
	@ApiOperation(value = "Devuelve un usuario en específico de la Base de Datos", response = Iterable.class, tags = "Datos por el id del usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operacion exitosa aquí está su usuario solicitado..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Object> getUsuarioById(@PathVariable long id){
		try {
			return ResponseEntity.ok(usuarioService.getUsuarioById(id));						
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Crea usuarios en la Base de Datos", response = Iterable.class, tags = "Crear un usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operacion exitosa, usuario creado con éxito..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) throws ApiUnprocessableEntity{
		return ResponseEntity.ok().body(this.usuarioService.createUsuario(usuario));
	}
	
	@ApiOperation(value = "Actualiza los datos de un usuario específico en la Base de Datos", response = Iterable.class, tags = "Actualizar un usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operacion exitosa, usuario actualizado con éxito..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable long id, @RequestBody Usuario usuario) throws ApiUnprocessableEntity{
		usuario.setId(id);
		try {
			return ResponseEntity.ok().body(this.usuarioService.updateUsuario(usuario));			
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}	
	
	@ApiOperation(value = "Elimina un usuario en específico en la Base de Datos", response = Iterable.class, tags = "Eliminar un usuario")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "Operacion exitosa, usuario eliminado..."),
			@ApiResponse(code = 204, message = "No content..."),
			@ApiResponse(code = 401, message = "Credenciales No Autorizadas..."),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "La dirección web no se encuentra...")
	})
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable long id) throws ApiUnprocessableEntity{
		try {
			this.userValidator.validator(id);
			this.usuarioService.deleteUsuario(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
