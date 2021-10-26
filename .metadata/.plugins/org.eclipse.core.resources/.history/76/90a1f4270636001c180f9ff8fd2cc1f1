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

@Api(value = "{user.controller.api}", tags = "{user.controller.api.tags}")
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

	@ApiOperation(value = "{user.controller.apioperation.all}", response = ResponseEntity.class, tags = "{user.controller.apioperation.tags.all}")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "{user.controller.response.200}"),
			@ApiResponse(code = 401, message = "{user.controller.response.401}"),
			@ApiResponse(code = 403, message = "{user.controller.response.403}"),
			@ApiResponse(code = 404, message = "{user.controller.response.404}")
	})
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
			return ResponseEntity.ok(usuarioService.getAllUsuario());
	}
	
	@ApiOperation(value = "{user.controller.apioperation.byid}", response = ResponseEntity.class, tags = "{user.controller.apioperation.tags.byid}")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "{user.controller.response.200}"),
			@ApiResponse(code = 401, message = "{user.controller.response.401}"),
			@ApiResponse(code = 403, message = "{user.controller.response.403}"),
			@ApiResponse(code = 404, message = "{user.controller.response.404}")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsuarioById(@PathVariable long id){
		try {
			return ResponseEntity.ok(usuarioService.getUsuarioById(id));						
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "{user.controller.apioperation.create}", response = ResponseEntity.class, tags = "{user.controller.apioperation.tags.create}")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "{user.controller.response.200}"),
			@ApiResponse(code = 401, message = "{user.controller.response.401}"),
			@ApiResponse(code = 403, message = "{user.controller.response.403}"),
			@ApiResponse(code = 404, message = "{user.controller.response.404}")
	})
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody UsuarioRequest usuario) throws ApiUnprocessableEntity{
		return ResponseEntity.ok().body(this.usuarioService.createUsuario(usuario));
	}
	
	@ApiOperation(value = "{user.controller.apioperation.update}", response = ResponseEntity.class, tags = "{user.controller.apioperation.tags.update}")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "{user.controller.response.200}"),
			@ApiResponse(code = 401, message = "{user.controller.response.401}"),
			@ApiResponse(code = 403, message = "{user.controller.response.403}"),
			@ApiResponse(code = 404, message = "{user.controller.response.404}")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) throws ApiUnprocessableEntity{
		try {
			return ResponseEntity.ok().body(this.usuarioService.updateUsuario(usuarioRequest, id));
		}catch(ResourceNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}	
	
	@ApiOperation(value = "{user.controller.apioperation.delete}", response = ResponseEntity.class, tags = "{user.controller.apioperation.tags.delete}")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "{user.controller.response.200}"),
			@ApiResponse(code = 401, message = "{user.controller.response.401}"),
			@ApiResponse(code = 403, message = "{user.controller.response.403}"),
			@ApiResponse(code = 404, message = "{user.controller.response.404}")
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

	@ApiOperation(value = "{user.controller.apioperation.hi}", response = ResponseEntity.class, tags = "{user.controller.apioperation.hi}")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "{user.controller.response.200}"),
			@ApiResponse(code = 401, message = "{user.controller.response.401}"),
			@ApiResponse(code = 403, message = "{user.controller.response.403}"),
			@ApiResponse(code = 404, message = "{user.controller.response.404}")
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
