package org.cardenete.dao.specific;

import org.cardenete.entity.UsuarioBean;

public interface LoginDao {
	public UsuarioBean login(String user, String pass);
	
	public UsuarioBean getUserByToken(String login, String token);
	
	public boolean checkUsernameIsAvailable(String username);
	
	public boolean checkEmailIsAvailable(String email);
}
