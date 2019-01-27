package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.CategoriaBean;
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
public class CategoriaRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@GetMapping("/categorias/{idCategoria}")
	public CategoriaBean getCategoria(@PathVariable int idCategoria) {

		if (genericService.get(CategoriaBean.class, idCategoria) == null) {
			throw new BeanNotFoundException("Categoria con el id: " + idCategoria + " no encontrado.");
		}
		return genericService.get(CategoriaBean.class, idCategoria);
	}

	@GetMapping("/categorias")
	public List<CategoriaBean> getAllCategorias() {
		return (List<CategoriaBean>) genericService.getAll(CategoriaBean.class);
	}

	@PostMapping("/categorias")
	public ResponseBean addCategoria(@RequestBody CategoriaBean oCategoria) {
		return new ResponseBean(200, String.valueOf(genericService.save(oCategoria)));
	}

	@PutMapping("/categorias")
	public ResponseBean updateBean(@RequestBody CategoriaBean oCategoria) {

		// throw exception if null
		if (genericService.get(CategoriaBean.class, oCategoria.getId()) == null) {
			throw new BeanNotFoundException("Categoria con el id: " + oCategoria.getId() + " no encontrado.");
		}

		return new ResponseBean(200, genericService.saveOrUpdate(oCategoria));
	}

	@DeleteMapping("/categorias/{idCategoria}")
	public ResponseBean deleteCustomer(@PathVariable int idCategoria) {

		CategoriaBean oCategoria = genericService.get(CategoriaBean.class, idCategoria);

		// throw exception if null
		if (oCategoria == null) {
			throw new BeanNotFoundException("Categoria con el id: " + idCategoria + " no encontrado.");
		}

		genericService.delete(oCategoria);

		return new ResponseBean(200, "Categoria con id - " + idCategoria+" borrada.");
	}

}
