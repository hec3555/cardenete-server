package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.ResponseBean;
import org.cardenete.enums.RolesEnum;
import org.cardenete.entity.ArticuloBean;
import org.cardenete.entity.CategoriaBean;
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
public class CategoriaRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@Autowired
	private CheckPermission check;

	@GetMapping("/categorias/{idCategoria}")
	public CategoriaBean getCategoria(@PathVariable int idCategoria) {

		if (genericService.get(CategoriaBean.class, idCategoria) == null) {
			throw new BeanNotFoundException("Categoria con el id: " + idCategoria + " no encontrado.");
		}
		return genericService.get(CategoriaBean.class, idCategoria);
	}

	@GetMapping("/categorias")
	public List<CategoriaBean> getAllCategorias() {
		
		List<CategoriaBean> listaCategorias = (List<CategoriaBean>) genericService.getAll(CategoriaBean.class);
		if(listaCategorias.size() < 1) {
			throw new EmptyListException("Sin resultados");
		}else {
			return listaCategorias;
		}
	}

	@PostMapping("/categorias")
	public ResponseBean addCategoria(@RequestBody CategoriaBean oCategoria) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			return new ResponseBean(200, String.valueOf(genericService.save(oCategoria)));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@PutMapping("/categorias")
	public ResponseBean updateCategoria(@RequestBody CategoriaBean oCategoria) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			// throw exception if null
			if (genericService.get(CategoriaBean.class, oCategoria.getId()) == null) {
				throw new BeanNotFoundException("Categoria con el id: " + oCategoria.getId() + " no encontrado.");
			}

			return new ResponseBean(200, genericService.saveOrUpdate(oCategoria));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@DeleteMapping("/categorias/{idCategoria}")
	public ResponseBean deleteCategoria(@PathVariable int idCategoria) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			CategoriaBean oCategoria = genericService.get(CategoriaBean.class, idCategoria);

			// throw exception if null
			if (oCategoria == null) {
				throw new BeanNotFoundException("Categoria con el id: " + idCategoria + " no encontrado.");
			}

			genericService.delete(oCategoria);

			return new ResponseBean(200, "Categoria con id - " + idCategoria + " borrada.");
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

}
