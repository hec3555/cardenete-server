package org.cardenete.rest;

import java.util.Date;
import java.util.List;

import org.cardenete.entity.ArticuloBean;
import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.SeccionBean;
import org.cardenete.entity.UsuarioBean;
import org.cardenete.enums.RolesEnum;
import org.cardenete.exceptions.BeanNotFoundException;
import org.cardenete.exceptions.EmptyListException;
import org.cardenete.exceptions.NotAuthException;
import org.cardenete.service.ArticuloService;
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
public class ArticuloRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@Autowired
	private ArticuloService articuloService;

	@Autowired
	private CheckPermission check;

	@GetMapping("/articulos/{idArticulo}")
	public ArticuloBean getArticulo(@PathVariable int idArticulo) {

		if (genericService.get(ArticuloBean.class, idArticulo) == null) {
			throw new BeanNotFoundException("Articulo con el id: " + idArticulo + " no encontrado.");
		}
		return genericService.get(ArticuloBean.class, idArticulo);
	}

	@GetMapping("/articulos")
	public List<ArticuloBean> getAllArticulos() {
		
		List<ArticuloBean> listaArticulos = (List<ArticuloBean>) genericService.getAll(ArticuloBean.class);
		if(listaArticulos.size() < 1) {
			throw new EmptyListException("Sin resultados");
		}else {
			return listaArticulos;
		}
	}

	@GetMapping("/articulos/seccion/{idSeccion}")
	public List<ArticuloBean> getArticulosBySeccion(@PathVariable int idSeccion) {
		if (genericService.get(SeccionBean.class, idSeccion) == null) {
			throw new BeanNotFoundException("Sección con el id: " + idSeccion + " no encontrada.");
		}

		List<ArticuloBean> listaArticulos = (List<ArticuloBean>) articuloService.getAllBySeccion(idSeccion);
		if(listaArticulos.size() < 1) {
			throw new EmptyListException("Sin resultados");
		}else {
			return listaArticulos;
		}
	}

	@GetMapping("/articulos/usuario/{idUsuario}")
	public List<ArticuloBean> getArticulosByUsuario(@PathVariable int idUsuario) {
		if (genericService.get(UsuarioBean.class, idUsuario) == null) {
			throw new BeanNotFoundException("Usuario con el id: " + idUsuario + " no encontrado.");
		}
		
		List<ArticuloBean> listaArticulos = (List<ArticuloBean>) articuloService.getAllByUsuario(idUsuario);
		if(listaArticulos.size() < 1) {
			throw new EmptyListException("Sin resultados");
		}else {
			return listaArticulos;
		}

	}

	@GetMapping("/articulos/seccion/{idSeccion}/usuario/{idUsuario}")
	public List<ArticuloBean> getAllByUsuarioAndSeccion(@PathVariable int idSeccion, @PathVariable int idUsuario) {

		if (genericService.get(SeccionBean.class, idSeccion) == null) {
			throw new BeanNotFoundException("Sección con el id: " + idSeccion + " no encontrada.");
		}

		if (genericService.get(UsuarioBean.class, idUsuario) == null) {
			throw new BeanNotFoundException("Usuario con el id: " + idUsuario + " no encontrado.");
		}

		
		List<ArticuloBean> listaArticulos = (List<ArticuloBean>) articuloService.getAllBySeccionAndUsuario(idSeccion, idUsuario);
		if(listaArticulos.size() < 1) {
			throw new EmptyListException("Sin resultados");
		}else {
			return listaArticulos;
		}
	}

	@PostMapping("/articulos")
	public ResponseBean addArticulo(@RequestBody ArticuloBean oArticulo) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			Date fecha = new Date();
			oArticulo.setFecha(fecha);

			return new ResponseBean(200, String.valueOf(genericService.save(oArticulo)));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@PutMapping("/articulos")
	public ResponseBean updateArticulo(@RequestBody ArticuloBean oArticulo) {
		// Si un admin pone que el articulo es de un usuario de tipo usuario, este podrá editar el articulo porque es suyo,
		// pero para ello un admin debe especificar que el articulo le pertenece, un usuario no puede crear articulos
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId) || check.checkSameUserSession(oArticulo.getId_usuario().getId())) {
			// throw exception if null
			if (genericService.get(ArticuloBean.class, oArticulo.getId()) == null) {
				throw new BeanNotFoundException("Articulo con el id: " + oArticulo.getId() + " no encontrado.");
			}

			if (oArticulo.getFecha() == null) {
				ArticuloBean articuloAux = genericService.get(ArticuloBean.class, oArticulo.getId());
				oArticulo.setFecha(articuloAux.getFecha());
			}

			return new ResponseBean(200, genericService.saveOrUpdate(oArticulo));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@DeleteMapping("/articulos/{idArticulo}")
	public ResponseBean deleteArticulo(@PathVariable int idArticulo) {
		if (check.checkRolePermissions(RolesEnum.ADMIN.roleId)) {
			ArticuloBean oArticulo = genericService.get(ArticuloBean.class, idArticulo);

			// throw exception if null
			if (oArticulo == null) {
				throw new BeanNotFoundException("Articulo con el id: " + idArticulo + " no encontrado.");
			}

			genericService.delete(oArticulo);

			return new ResponseBean(200, "Articulo con id - " + idArticulo + " borrada.");
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

}
