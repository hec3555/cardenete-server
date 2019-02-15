package org.cardenete.service;

import org.cardenete.entity.UsuarioBean;

public interface LoginService {
	public UsuarioBean login(String usuario, String pass);
}
