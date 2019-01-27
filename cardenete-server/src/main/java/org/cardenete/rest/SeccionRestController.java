package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.SeccionBean;
import org.cardenete.exceptions.BeanNotFoundException;
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
public class SeccionRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@GetMapping("/secciones/{idSeccion}")
	public SeccionBean getSeccion(@PathVariable int idSeccion) {

		if (genericService.get(SeccionBean.class, idSeccion) == null) {
			throw new BeanNotFoundException("Seccion con el id: " + idSeccion + " no encontrado.");
		}
		return genericService.get(SeccionBean.class, idSeccion);
	}

	@GetMapping("/secciones")
	public List<SeccionBean> getAllSecciones() {
		return (List<SeccionBean>) genericService.getAll(SeccionBean.class);
	}

	@PostMapping("/secciones")
	public ResponseBean addSeccion(@RequestBody SeccionBean oSeccion) {
		return new ResponseBean(200, String.valueOf(genericService.save(oSeccion)));
	}

	@PutMapping("/secciones")
	public ResponseBean updateBean(@RequestBody SeccionBean oSeccion) {

		// throw exception if null
		if (genericService.get(SeccionBean.class, oSeccion.getId()) == null) {
			throw new BeanNotFoundException("Seccion con el id: " + oSeccion.getId() + " no encontrado.");
		}

		return new ResponseBean(200, genericService.saveOrUpdate(oSeccion));
	}

	@DeleteMapping("/secciones/{idSeccion}")
	public ResponseBean deleteCustomer(@PathVariable int idSeccion) {

		SeccionBean oSeccion = genericService.get(SeccionBean.class, idSeccion);

		// throw exception if null
		if (oSeccion == null) {
			throw new BeanNotFoundException("Seccion con el id: " + idSeccion + " no encontrado.");
		}

		genericService.delete(oSeccion);

		return new ResponseBean(200, "Seccion con id - " + idSeccion+" borrado.");
	}

}
