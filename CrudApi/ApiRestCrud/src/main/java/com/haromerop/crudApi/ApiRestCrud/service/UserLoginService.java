package com.haromerop.crudApi.ApiRestCrud.service;

import com.haromerop.crudApi.ApiRestCrud.dto.UserLoginRequest;
import com.haromerop.crudApi.ApiRestCrud.model.UserLogin;

public interface UserLoginService {
	UserLogin createUser(UserLoginRequest userRequest);
}
