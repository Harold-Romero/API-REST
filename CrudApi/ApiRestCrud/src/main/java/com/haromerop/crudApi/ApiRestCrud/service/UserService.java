package com.haromerop.crudApi.ApiRestCrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.haromerop.crudApi.ApiRestCrud.model.UserLogin;
import com.haromerop.crudApi.ApiRestCrud.repository.GestorUser;

@Service("userService")
public class UserService implements UserDetailsService{
	
	@Autowired
	@Qualifier("gestorUser")
	private GestorUser repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin user = repo.findbyUser(username);
		return new User(user.getUser(), user.getPass(), user.isSession(), user.isSession(), user.isSession(), user.isSession(), buildgrante(user.getRol()));
	}
	
	public List<GrantedAuthority> buildgrante(byte rol){
		String[] roles = {"LECTOR", "USUARIO", "ADMINISTRADOR"};
		List<GrantedAuthority> auths = new ArrayList<>();
		
		for (int i = 0; i<rol; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));			
		}
		
		return auths;
	}
}
