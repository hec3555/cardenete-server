package org.cardenete.service;

import org.cardenete.entity.UsuarioBean;

public interface LoginService {
	public UsuarioBean login(String usuario, String pass);
	
	public UsuarioBean getUserByToken(String login, String token);

	public boolean checkUsernameIsAvailable(String username);

	public boolean checkEmailIsAvailable(String email);
}
