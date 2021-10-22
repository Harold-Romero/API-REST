package com.haromerop.crudApi.ApiRestCrud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UsuarioRequest {

    @ApiModelProperty(notes = "Nombre del usuario", name = "nombre", required = true, value = "Nombres del usuario")
    @NotEmpty(message = "{user.entity.firstname.empty}")
    @Length(min = 3, max = 15, message = "Debe enviar un nombre entre 3 carácteres y 15 carácteres...")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "Debe enviar solo letras en el nombre")
    private String nombresUsuario;

    @ApiModelProperty(notes = "Apellidos del usuario", name = "apellidos", required = true, value = "Apellidos del usuario")
    @NotEmpty(message = "El apellido no puede estar vacío...")
    @Length(min = 3, max = 25, message = "Debe enviar un apellido entre 3 carácteres y 25 carácteres...")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "Debe enviar solo letras para el apellido")
    private String apellidosUsuario;

    @ApiModelProperty(notes = "Telefono del usuario", name = "telefono", required = true, value = "Telefono del usuario")
    @NotEmpty(message = "El teléfono no puede estar vacío...")
    @Length(min = 7, max = 15, message = "El teléfono no puede tener menos de 7 carácteres y más de 15 caráctes...")
    @Pattern(regexp = "[0-9]+", message = "Debe enviar solo números para el teléfono")
    private String telefono;

    @ApiModelProperty(notes = "Direccion del usuario", name = "direccion", required = true, value = "Direccion del usuario")
    @NotEmpty(message = "La dirección no puede estar vacía...")
    @Length(min = 9, max = 30, message = "La dirección no puede tener menos de 9 carácteres y más de 30 caráctes...")
    private String direccion;
}
