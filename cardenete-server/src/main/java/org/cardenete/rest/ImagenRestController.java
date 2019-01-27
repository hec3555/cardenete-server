package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.ImagenBean;
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
public class ImagenRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@GetMapping("/imagenes/{idImagen}")
	public ImagenBean getImagen(@PathVariable int idImagen) {

		if (genericService.get(ImagenBean.class, idImagen) == null) {
			throw new BeanNotFoundException("Imagen con el id: " + idImagen + " no encontrado.");
		}
		return genericService.get(ImagenBean.class, idImagen);
	}

	@GetMapping("/imagenes")
	public List<ImagenBean> getAllImagenes() {
		return (List<ImagenBean>) genericService.getAll(ImagenBean.class);
	}

	@PostMapping("/imagenes")
	public ResponseBean addImagen(@RequestBody ImagenBean oImagen) {
		return new ResponseBean(200, String.valueOf(genericService.save(oImagen)));
	}

	@PutMapping("/imagenes")
	public ResponseBean updateBean(@RequestBody ImagenBean oImagen) {

		// throw exception if null
		if (genericService.get(ImagenBean.class, oImagen.getId()) == null) {
			throw new BeanNotFoundException("Imagen con el id: " + oImagen.getId() + " no encontrado.");
		}

		return new ResponseBean(200, genericService.saveOrUpdate(oImagen));
	}

	@DeleteMapping("/imagenes/{idImagen}")
	public ResponseBean deleteCustomer(@PathVariable int idImagen) {

		ImagenBean oImagen = genericService.get(ImagenBean.class, idImagen);

		// throw exception if null
		if (oImagen == null) {
			throw new BeanNotFoundException("Imagen con el id: " + idImagen + " no encontrado.");
		}

		genericService.delete(oImagen);

		return new ResponseBean(200, "Imagen con id - " + idImagen+" borrada.");
	}

}
