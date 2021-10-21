package com.haromerop.crudApi.ApiRestCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haromerop.crudApi.ApiRestCrud.model.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{
	
}
