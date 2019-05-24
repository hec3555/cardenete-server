package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.ImagenBean;
import org.cardenete.entity.ResponseBean;
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
public class ImagenRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@Autowired
	private CheckPermission check;

	@GetMapping("/imagenes/{idImagen}")
	public ImagenBean getImagen(@PathVariable int idImagen) {

		if (genericService.get(ImagenBean.class, idImagen) == null) {
			throw new BeanNotFoundException("Imagen con el id: " + idImagen + " no encontrado.");
		}
		return genericService.get(ImagenBean.class, idImagen);
	}

	@GetMapping("/imagenes")
	public List<ImagenBean> getAllImagenes() {
		
		List<ImagenBean> listaImagenes = (List<ImagenBean>) genericService.getAll(ImagenBean.class);
		if(listaImagenes.size() < 1) {
			throw new EmptyListException("Sin resultados");
		}else {
			return listaImagenes;
		}
		
	}

	@PostMapping("/imagenes")
	public ResponseBean addImagen(@RequestBody ImagenBean oImagen) {
		// Si no estás loggeado no puedes añadir imágenes
		if(check.checkIsLogged()) {
			return new ResponseBean(200, String.valueOf(genericService.save(oImagen)));			
		}else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@PutMapping("/imagenes")
	public ResponseBean updateImagen(@RequestBody ImagenBean oImagen) {
		if (check.checkIsLogged() && check.checkSameUserSession(oImagen.getId_usuario().getId())) {
			// throw exception if null
			if (genericService.get(ImagenBean.class, oImagen.getId()) == null) {
				throw new BeanNotFoundException("Imagen con el id: " + oImagen.getId() + " no encontrado.");
			}

			return new ResponseBean(200, genericService.saveOrUpdate(oImagen));
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

	@DeleteMapping("/imagenes/{idImagen}")
	public ResponseBean deleteImagen(@PathVariable int idImagen) {
		ImagenBean oImagen = genericService.get(ImagenBean.class, idImagen);
		// throw exception if null
		if (oImagen == null) {
			throw new BeanNotFoundException("Imagen con el id: " + idImagen + " no encontrado.");
		}
		if (check.checkSameUserSession(oImagen.getId_usuario().getId())) {

			genericService.delete(oImagen);

			return new ResponseBean(200, "Imagen con id - " + idImagen + " borrada.");
		} else {
			throw new NotAuthException("No tienes suficientes permisos.");
		}
	}

}
