package org.cardenete.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.cardenete.entity.ArticuloBean;
import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.TipoUsuarioBean;
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
public class TipoUsuarioRestController {

	@Autowired
	private GenericServiceInterface genericService;

	@Autowired
	HttpServletRequest servletRequest;

	@Autowired
	private CheckPermission check;

	@GetMapping("/tipousuarios/{idTipoUsuario}")
	public TipoUsuarioBean getUsuario(@PathVariable int idTipoUsuario) {
		TipoUsuarioBean tipoUsuario = genericService.get(TipoUsuarioBean.class, idTipoUsuario);
		UsuarioBean usuarioSession = (UsuarioBean) servletRequest.getSession().getAttribute("usuario");
		if ((check.checkRolePermissions(RolesEnum.ADMIN.roleId)
				|| usuarioSession.getId_tipo_usuario().getId() == tipoUsuario.getId()) && tipoUsuario != null) {
			return genericService.get(TipoUsuarioBean.class, idTipoUsuario);
		} else {
			if (tipoUsuario == null && check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
				throw new BeanNotFoundException("Tipo de usuario con el id - " + idTipoUsuario + " no encontrado.");
			} else {
				throw new NotAuthException("No tienes suficientes permisos.");
			}
		}
	}

	@GetMapping("/tipousuarios")
	public List<TipoUsuarioBean> getAllUsuarios() {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			List<TipoUsuarioBean> listaTipoUsuarios = (List<TipoUsuarioBean>) genericService
					.getAll(TipoUsuarioBean.class);
			if (listaTipoUsuarios.size() < 1) {
				throw new EmptyListException("Sin resultados");
			} else {
				return listaTipoUsuarios;
			}
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}

	}

	@PostMapping("/tipousuarios")
	public ResponseBean addTipoUsuario(@RequestBody TipoUsuarioBean oTipoUsuario) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			return new ResponseBean(200, String.valueOf(genericService.save(oTipoUsuario)));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@PutMapping("/tipousuarios")
	public ResponseBean updateBean(@RequestBody TipoUsuarioBean oTipoUsuario) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			// throw exception if null
			if (genericService.get(TipoUsuarioBean.class, oTipoUsuario.getId()) == null) {
				throw new BeanNotFoundException(
						"Tipo de usuario con el id - " + oTipoUsuario.getId() + " no encontrado.");
			}

			return new ResponseBean(200, genericService.saveOrUpdate(oTipoUsuario));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@DeleteMapping("/tipousuarios/{idTipoUsuario}")
	public ResponseBean deleteCustomer(@PathVariable int idTipoUsuario) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			TipoUsuarioBean oTipoUsuario = genericService.get(TipoUsuarioBean.class, idTipoUsuario);

			// throw exception if null
			if (oTipoUsuario == null) {
				throw new BeanNotFoundException("Tipo de usuario con el id - " + idTipoUsuario + " no encontrado.");
			}

			genericService.delete(oTipoUsuario);

			return new ResponseBean(200, "Tipo usuario con id - " + idTipoUsuario + " borrado.");
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}
}
