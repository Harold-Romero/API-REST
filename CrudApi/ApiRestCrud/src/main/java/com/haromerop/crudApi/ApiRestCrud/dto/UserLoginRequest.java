package com.haromerop.crudApi.ApiRestCrud.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginRequest {
	
	@ApiModelProperty(notes = "{user.entity.username.apimodelproperty}", name="nombre", required=true, value="{user.entity.firstname.apimodelproperty}")
    @NotEmpty(message = "{user.entity.firstname.empty}")
    @Length(min = 3, max = 15, message = "{user.entity.firstname.length}")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "{user.entity.firstname.pattern}")
	private String user;
	private String pass;
	private byte rol;
	private boolean session;
	
}
