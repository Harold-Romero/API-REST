package com.haromerop.crudApi.ApiRestCrud.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.haromerop.crudApi.ApiRestCrud.dto.UserLoginRequest;
import com.haromerop.crudApi.ApiRestCrud.model.UserLogin;
import com.haromerop.crudApi.ApiRestCrud.repository.UserLoginRepository;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private final UserLoginRepository repository;

	public UserLoginServiceImpl(UserLoginRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserLogin createUser(UserLoginRequest userRequest) {
		
		String passEncript =  bCryptPasswordEncoder.encode(userRequest.getPass());
		
		UserLogin user = new UserLogin();
		user.setUser(userRequest.getUser());
		user.setPass(passEncript);
		user.setRol(userRequest.getRol());
		return repository.save(user);
	}
}
