package org.cardenete.rest;

import java.util.Date;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cardenete.email.EmailSender;
import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.UsuarioBean;
import org.cardenete.exceptions.BeanNotFoundException;
import org.cardenete.exceptions.NotAuthException;
import org.cardenete.exceptions.NotLoggedException;
import org.cardenete.service.LoginService;
import org.cardenete.service.generic.GenericServiceInterface;
import org.cardenete.validations.CheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardenete")
public class LoginRestController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private GenericServiceInterface genericService;

	// Para cada ruta haremos un check de lo que sea necesario, permitiendo o
	// denegando acceso
	@Autowired
	private CheckPermission check;
	
	@Autowired
	private EmailSender emailSender;
	

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
				if(!oUsuarioBean.isConfirmado()) {
					// ENVIAR EMAIL DE VERIFICACIÓN
					try {
						emailSender.sendVerificationEmail(oUsuario.getEmail());
					} catch (MessagingException ex) {
						response.setStatus(500);
						return new ResponseBean(500, "Error al enviar mail de verificacion");
					}
					
					
					response.setStatus(401);
					return new ResponseBean(401, "Usuario no confirmado, por favor, revisa tu correo y haz clic en el enlace para confirmar.");
				}
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
	
	@PostMapping("/registrar")
	public ResponseBean registrar(@RequestBody UsuarioBean oUsuario) {
		
			// generar token 
			UUID uuid = UUID.randomUUID();
			String token = uuid.toString();
			oUsuario.setToken(token);
			
			// usuario con confirmado = false
			oUsuario.setConfirmado(false);
			
			// enviar mail de verificacion
			
			// si un usuario inicia sesión y está deshabilitado, informar y reenviar mail de verificacion
		
			Date fechaAlta = new Date();
			oUsuario.setFecha_alta(fechaAlta);

			return new ResponseBean(200, String.valueOf(genericService.save(oUsuario)));
	}
	
	@GetMapping("/check-username-availability/{username}")
	public ResponseBean checkUsernameIsAvailable(@PathVariable String username) {
		return new ResponseBean(200, String.valueOf(loginService.checkUsernameIsAvailable(username)));
	}
	
	@GetMapping("/check-email-availability/{email}")
	public ResponseBean checkEmailIsAvailable(@PathVariable String email) {
		return new ResponseBean(200, String.valueOf(loginService.checkEmailIsAvailable(email)));
	}
	
	// crear metodo para activar el usuario (enlace se enviará x correo)
	@GetMapping("/confirm/{login}/{token}")
	public ResponseBean confirmUsuario(@PathVariable String login, @PathVariable String token) {

			
			UsuarioBean oUsuarioBean = loginService.getUserByToken(login, token);
			// throw exception if null
			if (oUsuarioBean == null) {
				throw new BeanNotFoundException("Usuario no encontrado.");
			}else {
				oUsuarioBean.setConfirmado(true);
				genericService.saveOrUpdate(oUsuarioBean);
				return new ResponseBean(200, "Usuario confirmado correctamente");
			}
	}

}
