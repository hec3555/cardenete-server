package validations;

import javax.servlet.http.HttpServletRequest;

import org.cardenete.entity.UsuarioBean;
import org.cardenete.exceptions.NotAuthException;
import org.cardenete.exceptions.NotLoggedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CheckPermission {
	
	@Autowired
	HttpServletRequest servletRequest;
	
	public void checkPermissions(int permission) {
		UsuarioBean usuarioSession = (UsuarioBean) servletRequest.getSession().getAttribute("usuario");
		
		if(usuarioSession == null) throw new NotLoggedException("No estas logeado.");
		
		if(usuarioSession.getId_tipo_usuario().getId() != permission) throw new NotAuthException("No autorizado.");
	}
	
	

}