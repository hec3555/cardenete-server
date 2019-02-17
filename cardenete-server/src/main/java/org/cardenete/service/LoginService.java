package org.cardenete.service;

import org.cardenete.entity.UsuarioBean;
import org.springframework.stereotype.Service;

public interface LoginService {
	public UsuarioBean login(String usuario, String pass);
}
