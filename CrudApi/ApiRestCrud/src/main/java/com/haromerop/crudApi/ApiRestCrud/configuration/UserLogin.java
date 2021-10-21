package com.haromerop.crudApi.ApiRestCrud.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// anotaciones para hacer los getters y setters a los atributos
@Data
//crea un constructor con todos los argumentos
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
	
	private String user;
	private String password;
	
}
