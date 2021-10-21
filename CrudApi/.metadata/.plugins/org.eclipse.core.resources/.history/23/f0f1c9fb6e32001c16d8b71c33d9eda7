package com.haromerop.crudApi.ApiRestCrud.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_userlogin")
@Data
public class UserLogin{
	
	@Id
	@GeneratedValue
	@Column(name = "idUser", unique = true)
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