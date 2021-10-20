package com.haromerop.crudApi.ApiRestCrud.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.util.Collections.emptyList;

public class JwtUtil {
	
	// Método para crear el JWT y enviarlo al cliente  en el header de la respuesta
	static void addAuthentication(HttpServletResponse res, String username) {
		
		String token = Jwts.builder()
				.setSubject(username)
				//Hash con el que se va a firmar la clave
				.signWith(SignatureAlgorithm.HS512, "P@tit0")
				.compact();
		//Se le agrega al encabezado el token
		res.addHeader("Authorization", "Bearer " + token);
	}
	
	// Método para validar el token enviado por el cliente
	static Authentication getAuthentication(HttpServletRequest request) {
		
		// Obtenemos el token que viene del encabezado de la petición
		String token = request.getHeader("Authorization");
		
		// Si hay token presente entonces se valida
		if (token != null) {
			
			String user = Jwts.parser()
					.setSigningKey("P@tit0")
					// Este es el método que valida ↓↓↓
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			
			return user != null? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;	
		}
		return null;
	}
	
}
