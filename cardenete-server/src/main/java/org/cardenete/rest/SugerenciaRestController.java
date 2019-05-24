package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.SugerenciaBean;
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
public class SugerenciaRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@Autowired
	private CheckPermission check;

	@GetMapping("/sugerencias/{idSugerencia}")
	public SugerenciaBean getSugerencia(@PathVariable int idSugerencia) {

		SugerenciaBean sugerencia = genericService.get(SugerenciaBean.class, idSugerencia);

		if ((check.checkRolePermissions(RolesEnum.ADMIN.roleId)
				|| check.checkSameUserSession(sugerencia.getId_usuario().getId())) && sugerencia != null) {
			return genericService.get(SugerenciaBean.class, idSugerencia);
		} else {
			if (sugerencia == null && check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
				throw new BeanNotFoundException("Sugerencia con el id: " + idSugerencia + " no encontrada.");
			} else {
				throw new NotAuthException("No tienes suficientes permisos.");
			}
		}
	}

	@GetMapping("/sugerencias")
	public List<SugerenciaBean> getAllSugerencias() {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			List<SugerenciaBean> listaSugerencias = (List<SugerenciaBean>) genericService.getAll(SugerenciaBean.class);
			if (listaSugerencias.size() < 1) {
				throw new EmptyListException("Sin resultados");
			} else {
				return listaSugerencias;
			}
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@PostMapping("/sugerencias")
	public ResponseBean addSugerencia(@RequestBody SugerenciaBean oSugerencia) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)
				|| check.checkSameUserSession(oSugerencia.getId_usuario().getId())) {
			return new ResponseBean(200, String.valueOf(genericService.save(oSugerencia)));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@PutMapping("/sugerencias")
	public ResponseBean updateSugerencia(@RequestBody SugerenciaBean oSugerencia) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			// throw exception if null
			if (genericService.get(SugerenciaBean.class, oSugerencia.getId()) == null) {
				throw new BeanNotFoundException("Sugerencia con el id: " + oSugerencia.getId() + " no encontrada.");
			}

			return new ResponseBean(200, genericService.saveOrUpdate(oSugerencia));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@DeleteMapping("/sugerencias/{idSugerencia}")
	public ResponseBean deleteSugerencia(@PathVariable int idSugerencia) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			SugerenciaBean oSugerencia = genericService.get(SugerenciaBean.class, idSugerencia);

			// throw exception if null
			if (oSugerencia == null) {
				throw new BeanNotFoundException("Sugerencia con el id: " + idSugerencia + " no encontrada.");
			}

			genericService.delete(oSugerencia);

			return new ResponseBean(200, "Sugerencia con id - " + idSugerencia + " borrada.");
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

}
