package com.haromerop.crudApi.ApiRestCrud.validator;

import org.springframework.stereotype.Component;

import com.haromerop.crudApi.ApiRestCrud.exception.ApiUnprocessableEntity;
import com.haromerop.crudApi.ApiRestCrud.model.Usuario;

@Component
public class UserValidatorImpl implements UsuarioValidator{

	@Override
	public void validator(Usuario usuario) throws ApiUnprocessableEntity {
		 
		if(usuario.getNombresUsuario() == null || usuario.getNombresUsuario().isEmpty()) {
			
			this.message("El nombre es obligatorio");
		
		}else if(usuario.getApellidosUsuario() == null || usuario.getApellidosUsuario().isEmpty()){
			
			this.message("El apellido es obligatorio");
		
		}else if(usuario.getTelefono() == null || usuario.getTelefono().isEmpty()){
		
			this.message("El teléfono son obligatorio");
		
		}else if(usuario.getDireccion() == null || usuario.getDireccion().isEmpty()){
		
			this.message("La dirección es obligatoria");
		}
		
		if(usuario.getNombresUsuario().length() < 3) {
			
			this.message("El nombre es muy corto, debe tener mínimo 3 caracteres");
		
		}else if(usuario.getNombresUsuario().length() > 15){
			
			this.message("El nombre es muy largo, debe tener máximo 15 caracteres");
		
		}else if(usuario.getApellidosUsuario().length() < 3){
			
			this.message("El apellido es muy corto, debe tener mínimo 3 caracteres");
			
		}else if(usuario.getApellidosUsuario().length() > 20){
			
			this.message("El apellido es muy largo, debe tener máximo 20 caracteres");
			
		}else if(usuario.getTelefono().length() < 7){
		
			this.message("El teléfono es muy corto, debe tener mínimo 7 caracteres");
		
		}else if(usuario.getTelefono().length() > 25){
			
			this.message("El teléfono es muy largo, debe tener máximo 25 caracteres");
			
		}else if(usuario.getDireccion().length() < 9){
			
			this.message("La dirección es muy corta, debe tener mínimo 9 caracteres");
			
		}else if(usuario.getDireccion().length() > 30){
			
			this.message("La dirección es muy larga, debe tener máximo 30 caracteres");
			
		}				
	}
	
	public void validator(long id) throws ApiUnprocessableEntity {
		
		String idUsuario = id+"";
		if(idUsuario == null || idUsuario.isEmpty()) {
			
			this.message("El numero de id es obligatorio para eliminar el registro");
			
		}
	}
	
	private void message (String message) throws ApiUnprocessableEntity{
		
		throw new ApiUnprocessableEntity(message);
	}

}
