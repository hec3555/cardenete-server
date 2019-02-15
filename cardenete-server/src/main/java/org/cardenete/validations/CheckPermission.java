package org.cardenete.validations;

import javax.servlet.http.HttpServletRequest;

import org.cardenete.entity.UsuarioBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckPermission {
	
	// Hacer estos metodos booleanos en lugar de lanzar excepciones (que te paran el programa)
	// es mejor. Si quieres lanzar excepciones, cuando el metodo te devuelve false la lanzas.
	// así se pueden usar estos metodos en condiciones.

	@Autowired
	HttpServletRequest servletRequest;

	
	public boolean checkRolePermissions(int idTipoUsuario) {
		checkIsLogged();
		
		UsuarioBean usuarioSession =  (UsuarioBean) servletRequest.getSession().getAttribute("usuario");
		
		if (usuarioSession.getId_tipo_usuario().getId() != idTipoUsuario) {
			return false;
		}else {
			return true;
		}
	}
	
	// comprueba si el usuario que recibe es el mismo que hay en sesion
	// (para editar o ver, los usuarios solo pueden ver su propio perfil, por ejemplo)
	public boolean checkSameUserSession(int idUsuario) {
		UsuarioBean usuarioSession =  (UsuarioBean) servletRequest.getSession().getAttribute("usuario");
		if(usuarioSession.getId()!= idUsuario) {
			return false;
		}else {
			return true;
		}
	}
	
	
	// Comprueba si esta loggeado
	public boolean checkIsLogged() {
		UsuarioBean usuarioSession =  (UsuarioBean) servletRequest.getSession().getAttribute("usuario");
		if (usuarioSession == null) {
			return false;
		}else {
			return true;
		}
	}

}