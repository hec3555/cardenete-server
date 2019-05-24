package org.cardenete.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.UsuarioBean;
import org.cardenete.exceptions.NotAuthException;
import org.cardenete.exceptions.NotLoggedException;
import org.cardenete.service.LoginService;
import org.cardenete.validations.CheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardenete")
public class LoginRestController {

	@Autowired
	private LoginService loginService;

	// Para cada ruta haremos un check de lo que sea necesario, permitiendo o
	// denegando acceso
	@Autowired
	private CheckPermission check;

	@PostMapping("/login")
	public ResponseBean login(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			@RequestBody UsuarioBean oUsuario) {
		
//		Las lineas comentadas son para q no hagas login si ya estás logeado pero habría que meter la sesión del cliente en el local storage
//		del navegador para que al refrescar no te lleve al login otra vez
//		if (!check.checkIsLogged()) {
		session.invalidate();
		try {
			UsuarioBean oUsuarioBean = loginService.login(oUsuario.getLogin(), oUsuario.getPass());
			if (oUsuarioBean != null) {
				HttpSession newSesion = request.getSession();
				newSesion.setAttribute("usuario", oUsuarioBean);
				response.setStatus(200);
				return new ResponseBean(200, "Login correcto");
			} else {
				response.setStatus(401);
				return new ResponseBean(401, "Usuario o contraseña incorrectos");
			}
			
		} catch (NotAuthException ex) {
			response.setStatus(401);
			return new ResponseBean(401, "Error in login rest");
		}
//		}else {
//			throw new NotLoggedException("Ya has iniciado sesión. Cierra sesión para hacer un login");
//		}
		
		

	}

	@GetMapping("/logout")
	public ResponseBean logout(HttpSession session) {
		session.invalidate();
		return new ResponseBean(200, "logout correcto");
	}

	@GetMapping("/check")
	public UsuarioBean check(HttpServletRequest session) {
		if (check.checkIsLogged()) {
			return (UsuarioBean) session.getSession().getAttribute("usuario");
		}
		throw new NotLoggedException("No estas logeado");
	}

}
