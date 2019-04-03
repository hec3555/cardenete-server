package org.cardenete.rest;

import java.util.Date;
import java.util.List;

import org.cardenete.entity.ArticuloBean;
import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.SeccionBean;
import org.cardenete.entity.UsuarioBean;
import org.cardenete.exceptions.BeanNotFoundException;
import org.cardenete.service.ArticuloService;
import org.cardenete.service.generic.GenericServiceInterface;
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

	private ResponseBean responseBean;

	@GetMapping("/articulos/{idArticulo}")
	public ArticuloBean getArticulo(@PathVariable int idArticulo) {

		if (genericService.get(ArticuloBean.class, idArticulo) == null) {
			throw new BeanNotFoundException("Articulo con el id: " + idArticulo + " no encontrado.");
		}
		return genericService.get(ArticuloBean.class, idArticulo);
	}

	@GetMapping("/articulos")
	public List<ArticuloBean> getAllArticulos() {
		return (List<ArticuloBean>) genericService.getAll(ArticuloBean.class);
	}

	@GetMapping("/articulos/seccion/{idSeccion}")
	public List<ArticuloBean> getArticulosBySeccion(@PathVariable int idSeccion) {
		if (genericService.get(SeccionBean.class, idSeccion) == null) {
			throw new BeanNotFoundException("Sección con el id: " + idSeccion + " no encontrada.");
		}

		return (List<ArticuloBean>) articuloService.getAllBySeccion(idSeccion);
	}

	@GetMapping("/articulos/usuario/{idUsuario}")
	public List<ArticuloBean> getArticulosByUsuario(@PathVariable int idUsuario) {
//		if (genericService.get(UsuarioBean.class, idUsuario) == null) {
//			throw new BeanNotFoundException("Usuario con el id: " + idUsuario + " no encontrado.");
//		}
		return (List<ArticuloBean>) articuloService.getAllByUsuario(idUsuario);

	}

	@GetMapping("/articulos/usuario/{idUsuario}/seccion/{idSeccion}")
	public List<ArticuloBean> getAllByUsuarioAndSeccion(@PathVariable int idUsuario, @PathVariable int idSeccion) {

		if (genericService.get(UsuarioBean.class, idUsuario) == null) {
			throw new BeanNotFoundException("Usuario con el id: " + idUsuario + " no encontrado.");
		}

		if (genericService.get(SeccionBean.class, idSeccion) == null) {
			throw new BeanNotFoundException("Sección con el id: " + idSeccion + " no encontrada.");
		}

		return (List<ArticuloBean>) articuloService.getAllByUsuarioAndSeccion(idUsuario, idSeccion);
	}

	@PostMapping("/articulos")
	public ResponseBean addArticulo(@RequestBody ArticuloBean oArticulo) {
		Date fecha = new Date();
		oArticulo.setFecha(fecha);

		return new ResponseBean(200, String.valueOf(genericService.save(oArticulo)));
	}

	@PutMapping("/articulos")
	public ResponseBean updateBean(@RequestBody ArticuloBean oArticulo) {

		// throw exception if null
		if (genericService.get(ArticuloBean.class, oArticulo.getId()) == null) {
			throw new BeanNotFoundException("Articulo con el id: " + oArticulo.getId() + " no encontrado.");
		}

		if (oArticulo.getFecha() == null) {
			ArticuloBean articuloAux = genericService.get(ArticuloBean.class, oArticulo.getId());
			oArticulo.setFecha(articuloAux.getFecha());
		}

		return new ResponseBean(200, genericService.saveOrUpdate(oArticulo));
	}

	@DeleteMapping("/articulos/{idArticulo}")
	public ResponseBean deleteCustomer(@PathVariable int idArticulo) {

		ArticuloBean oArticulo = genericService.get(ArticuloBean.class, idArticulo);

		// throw exception if null
		if (oArticulo == null) {
			throw new BeanNotFoundException("Articulo con el id: " + idArticulo + " no encontrado.");
		}

		genericService.delete(oArticulo);

		return new ResponseBean(200, "Articulo con id - " + idArticulo + " borrada.");
	}

}
