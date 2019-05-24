package org.cardenete.rest;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.UsuarioBean;
import org.cardenete.enums.RolesEnum;
import org.cardenete.exceptions.BeanNotFoundException;
import org.cardenete.exceptions.EmptyListException;
import org.cardenete.exceptions.NotAuthException;
import org.cardenete.service.generic.GenericServiceInterface;
import org.cardenete.validations.CheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardenete")
public class UsuarioRestController {

	@Autowired
	private GenericServiceInterface genericService;

	// Para cada ruta haremos un check de lo que sea necesario, permitiendo o
	// denegando acceso
	@Autowired
	private CheckPermission check;

	@Autowired
	HttpServletRequest servletRequest;

	@GetMapping("/usuarios/{idUsuario}")
	public UsuarioBean getUsuario(@PathVariable int idUsuario) {

		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId) || check.checkSameUserSession(idUsuario)) {
			if (genericService.get(UsuarioBean.class, idUsuario) == null) {
				throw new BeanNotFoundException("Usuario con el id: " + idUsuario + " no encontrado.");
			}
			return genericService.get(UsuarioBean.class, idUsuario);
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@GetMapping("/usuarios")
	public List<UsuarioBean> getAllUsuarios() {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			List<UsuarioBean> listaUsuarios = (List<UsuarioBean>) genericService.getAll(UsuarioBean.class);
			if(listaUsuarios.size() < 1) {
				throw new EmptyListException("Sin resultados");
			}else {
				return listaUsuarios;
			}
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@PostMapping("/usuarios")
	public ResponseBean addUsuario(@RequestBody UsuarioBean oUsuario) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			Date fechaAlta = new Date();
			oUsuario.setFecha_alta(fechaAlta);

			return new ResponseBean(200, String.valueOf(genericService.save(oUsuario)));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@PutMapping("/usuarios")
	public ResponseBean updateUsuario(@RequestBody UsuarioBean oUsuario) {

		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			// throw exception if null
			if (genericService.get(UsuarioBean.class, oUsuario.getId()) == null) {
				throw new BeanNotFoundException("Usuario con el id: " + oUsuario.getId() + " no encontrado.");
			}

			// si el pass viene nulo o vacio, le ponemos la que ya tenía antes
			if (oUsuario.getPass() == null || oUsuario.getPass() == "") {
				UsuarioBean usuarioAux = genericService.get(UsuarioBean.class, oUsuario.getId());
				oUsuario.setPass(usuarioAux.getPass());
			}

			return new ResponseBean(200, genericService.saveOrUpdate(oUsuario));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@DeleteMapping("/usuarios/{idUsuario}")
	public ResponseBean deleteUsuario(@PathVariable int idUsuario) {

		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			UsuarioBean oUsuario = genericService.get(UsuarioBean.class, idUsuario);

			// throw exception if null
			if (oUsuario == null) {
				throw new BeanNotFoundException("Usuario con el id: " + idUsuario + " no encontrado.");
			}

			genericService.delete(oUsuario);

			return new ResponseBean(200, "Deleted user id - " + idUsuario);
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

}
