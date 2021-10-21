package com.haromerop.crudApi.ApiRestCrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tbl_userlogin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin{
	
	@Id
	@Column(name = "idUser", unique = true)	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "user.entity.username.apimodelproperty",name="nombre",required=true,value="user.entity.username.apimodelproperty")
	private Long id;
	@Column(name = "user", unique  = true)
	private String user;
	@Column(name = "pass")
	private String pass;
	@Column(name = "rol")
	private byte rol;
	@Column(name = "session")
	private boolean session;
	
	
}