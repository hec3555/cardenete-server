package org.cardenete.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.UsuarioBean;
import org.cardenete.exceptions.NotLoggedException;
import org.cardenete.service.LoginService;
import org.cardenete.validations.CheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardenete")
public class LoginRestController {
	
	@Autowired
	private LoginService loginService;

	
	private ResponseBean responseBean;
	
	// Para cada ruta haremos un check de lo que sea necesario, permitiendo o denegando acceso
	@Autowired
	private CheckPermission check;

	@GetMapping("/login/{user}/{pass}")
	public ResponseBean login(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			@PathVariable String user, @PathVariable String pass) {
		session.invalidate();
		UsuarioBean oUsuarioBean = loginService.login(user, pass);

		if (oUsuarioBean != null) {
			HttpSession newSesion = request.getSession();
			newSesion.setAttribute("usuario", oUsuarioBean);
			responseBean = new ResponseBean(200, "Login correcto");
		} else {
			responseBean = new ResponseBean(401, "Bad login");
		}
		response.setStatus(responseBean.getStatus());
		return responseBean;
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
