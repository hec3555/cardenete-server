package org.cardenete.dao.specific;

import org.cardenete.entity.UsuarioBean;

public interface LoginDao {
	public UsuarioBean login(String user, String pass);
}
