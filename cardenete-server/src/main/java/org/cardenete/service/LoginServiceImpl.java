package org.cardenete.service;

import org.cardenete.dao.specific.LoginDao;
import org.cardenete.entity.UsuarioBean;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public UsuarioBean login(String user, String pass) {
		return loginDao.login(user, pass);
	}

}
