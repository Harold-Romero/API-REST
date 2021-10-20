package com.haromerop.crudApi.ApiRestCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haromerop.crudApi.ApiRestCrud.model.UserLogin;

@Repository
public interface GestorUser extends JpaRepository<UserLogin, Long> {

    UserLogin findByUser(String user);
}
