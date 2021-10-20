package com.haromerop.crudApi.ApiRestCrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tbl_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "id del usuario",name="nombre",required=true,value="Id del usuario")
	private Long id;
	
	private String nombresUsuario;

	private String apellidosUsuario;

	private String telefono;

	private String direccion;
	
}
