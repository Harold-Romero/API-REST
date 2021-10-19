package com.haromerop.crudApi.ApiRestCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haromerop.crudApi.ApiRestCrud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
