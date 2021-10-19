package com.haromerop.crudApi.ApiRestCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haromerop.crudApi.ApiRestCrud.exception.ResourceNotFoundException;
import com.haromerop.crudApi.ApiRestCrud.model.Usuario;
import com.haromerop.crudApi.ApiRestCrud.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario createUsuario(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		Optional<Usuario> usuarioDb = this.repository.findById(usuario.getId());
		
		if (usuarioDb.isPresent()) {
			Usuario usuarioUpdate = usuarioDb.get();
			usuarioUpdate.setId(usuario.getId());
			usuarioUpdate.setNombresUsuario(usuario.getNombresUsuario());
			usuarioUpdate.setApellidosUsuario(usuario.getApellidosUsuario());
			usuarioUpdate.setTelefono(usuario.getTelefono());
			usuarioUpdate.setDireccion(usuario.getDireccion());
			repository.save(usuarioUpdate);
			
			return usuarioUpdate;
		}else {
			throw new ResourceNotFoundException("Usuario no registrado con id digitado: " + usuario.getId());
		}
	}

	@Override
	public List<Usuario> getAllUsuario() {
		return this.repository.findAll();
	}

	@Override
	public Usuario getUsuarioById(long usuarioId) {
		
		Optional<Usuario> usuarioDb = this.repository.findById(usuarioId);
		
		if (usuarioDb.isPresent()) {
			return usuarioDb.get();			
		}else {
			throw new ResourceNotFoundException("Usuario no registrado con id digitado: " + usuarioId);			
		}
	}

	@Override
	public void deleteUsuario(long usuarioId) {
		Optional<Usuario> usuarioDb = this.repository.findById(usuarioId);
		
		if (usuarioDb.isPresent()) {
			this.repository.delete(usuarioDb.get());			
		}else {
			throw new ResourceNotFoundException("Usuario no registrado con id digitado: " + usuarioId);			
		}		
	}

}
