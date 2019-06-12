package org.cardenete.service;

import javax.transaction.Transactional;

import org.cardenete.dao.specific.LoginDao;
import org.cardenete.entity.UsuarioBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Transactional
	@Override
	public UsuarioBean login(String user, String pass) {
		return loginDao.login(user, pass);
	}

	@Override
	public boolean checkUsernameIsAvailable(String username) {
		return loginDao.checkUsernameIsAvailable(username);
	}

	@Override
	public boolean checkEmailIsAvailable(String email) {
		return loginDao.checkEmailIsAvailable(email);
	}

	@Override
	public UsuarioBean getUserByToken(String login, String token) {
		return loginDao.getUserByToken(login, token);
	}

	@Transactional
	@Override
	public String getUserToken(String user, String pass) {
		return loginDao.getUserToken(user, pass);
	}

}
