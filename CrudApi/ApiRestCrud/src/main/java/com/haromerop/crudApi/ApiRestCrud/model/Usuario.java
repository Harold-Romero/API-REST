package com.haromerop.crudApi.ApiRestCrud.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tbl_usuario")
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "id del usuario",name="nombre",required=true,value="Id del usuario")
	private Long id;
	
	@ApiModelProperty(notes = "Nombre del usuario",name="nombre",required=true,value="Nombres del usuario")
	@NotEmpty(message = "El nombre no puede estar vacío...")
	@Length(min = 3, max = 15, message = "Debe enviar un nombre entre 3 carácteres y 15 carácteres...")
	@Pattern(regexp = "[A-Za-z\\s]+", message = "Debe enviar solo letras en el nombre")
	private String nombresUsuario;
	@ApiModelProperty(notes = "Apellidos del usuario",name="apellidos",required=true,value="Apellidos del usuario")
	@NotEmpty(message = "El apellido no puede estar vacío...")
	@Length(min = 3, max = 25, message = "Debe enviar un apellido entre 3 carácteres y 25 carácteres...")
	@Pattern(regexp = "[A-Za-z\\s]+", message = "Debe enviar solo letras para el apellido")
	private String apellidosUsuario;
	@ApiModelProperty(notes = "Telefono del usuario",name="telefono",required=true,value="Telefono del usuario")
	@NotEmpty(message = "El teléfono no puede estar vacío...")
	@Length(min = 7, max = 15, message = "El teléfono no puede tener menos de 7 carácteres y más de 15 caráctes...")
	@Pattern(regexp = "[0-9]+", message = "Debe enviar solo números para el teléfono")
	private String telefono;
	@ApiModelProperty(notes = "Direccion del usuario",name="direccion",required=true,value="Direccion del usuario")
	@NotEmpty(message = "La dirección no puede estar vacía...")
	@Length(min = 9, max = 30, message = "La dirección no puede tener menos de 9 carácteres y más de 30 caráctes...")
	private String direccion;
	
	//@Transient        -----para no mapear el atributo en la base de datos-----
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public Usuario(Long id, String nombresUsuario, String apellidosUsuario, String telefono, String direccion) {
		super();
		this.id = id;
		this.nombresUsuario = nombresUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombresUsuario() {
		return nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombresUsuario=" + nombresUsuario + ", apellidosUsuario=" + apellidosUsuario
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
	
}
