package com.haromerop.crudApi.ApiRestCrud.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.haromerop.crudApi.ApiRestCrud.model.Usuario;
import com.haromerop.crudApi.ApiRestCrud.repository.UsuarioRepository;

public class EstadoServiceTest {
	
	@Mock
	private UsuarioRepository repository;
	
	@InjectMocks
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(testClass: this);;
	
		usuario = new Usuario();
		usuario.setNombresUsuario("Juan");
		usuario.setApellidosUsuario("Muñoz"); 
		usuario.setTelefono("7965415"); 
		usuario.setDireccion("Calle 1 12 11");
	}
	
	@Test
	void findAll() {
		when(repository.findAll()).thenReturn(Arrays.asList(usuario));
		assertNotNull(usuarioService.getAllUsuario());
	}
}
