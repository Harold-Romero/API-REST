package com.haromerop.crudApi.ApiRestCrud.service;

import java.util.List;

import com.haromerop.crudApi.ApiRestCrud.model.Usuario;

public interface UsuarioService {
	Usuario createUsuario(Usuario usuario);
	
	Usuario updateUsuario(Usuario usuario);
	
	List<Usuario> getAllUsuario();
	
	Usuario getUsuarioById(long usuarioId);
	
	void deleteUsuario(long id);
}
