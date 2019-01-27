package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.SugerenciaBean;
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
public class SugerenciaRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@GetMapping("/sugerencias/{idSugerencia}")
	public SugerenciaBean getSugerencia(@PathVariable int idSugerencia) {

		if (genericService.get(SugerenciaBean.class, idSugerencia) == null) {
			throw new BeanNotFoundException("Sugerencia con el id: " + idSugerencia + " no encontrada.");
		}
		return genericService.get(SugerenciaBean.class, idSugerencia);
	}

	@GetMapping("/sugerencias")
	public List<SugerenciaBean> getAllSugerencias() {
		return (List<SugerenciaBean>) genericService.getAll(SugerenciaBean.class);
	}

	@PostMapping("/sugerencias")
	public ResponseBean addSugerencia(@RequestBody SugerenciaBean oSugerencia) {
		return new ResponseBean(200, String.valueOf(genericService.save(oSugerencia)));
	}

	@PutMapping("/sugerencias")
	public ResponseBean updateBean(@RequestBody SugerenciaBean oSugerencia) {

		// throw exception if null
		if (genericService.get(SugerenciaBean.class, oSugerencia.getId()) == null) {
			throw new BeanNotFoundException("Sugerencia con el id: " + oSugerencia.getId() + " no encontrada.");
		}

		return new ResponseBean(200, genericService.saveOrUpdate(oSugerencia));
	}

	@DeleteMapping("/sugerencias/{idSugerencia}")
	public ResponseBean deleteCustomer(@PathVariable int idSugerencia) {

		SugerenciaBean oSugerencia = genericService.get(SugerenciaBean.class, idSugerencia);

		// throw exception if null
		if (oSugerencia == null) {
			throw new BeanNotFoundException("Sugerencia con el id: " + idSugerencia + " no encontrada.");
		}

		genericService.delete(oSugerencia);

		return new ResponseBean(200, "Sugerencia con id - " + idSugerencia+" borrada.");
	}

}
