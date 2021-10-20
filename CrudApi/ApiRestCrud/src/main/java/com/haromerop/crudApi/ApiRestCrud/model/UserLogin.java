package com.haromerop.crudApi.ApiRestCrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_userlogin")
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
	
	/**
	public UserLogin(String user, String pass, byte rol, boolean session) {
		this.user = user;
		this.pass = pass;
		this.rol = rol;
		this.session = session;
	}
	*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public byte getRol() {
		return rol;
	}
	public void setRol(byte rol) {
		this.rol = rol;
	}
	public boolean isSession() {
		return session;
	}
	public void setSession(boolean session) {
		this.session = session;
	}
}