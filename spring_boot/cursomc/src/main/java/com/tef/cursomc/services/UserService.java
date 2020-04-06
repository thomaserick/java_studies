package com.tef.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.tef.cursomc.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		// Retorna o usuário do sucesso

		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
