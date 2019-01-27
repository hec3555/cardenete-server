package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.ResponseBean;
import org.cardenete.entity.TipoUsuarioBean;
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
public class TipoUsuarioRestController {
	
	@Autowired
	private GenericServiceInterface genericService;

	
	@GetMapping("/tipousuarios/{idTipoUsuario}")
	public TipoUsuarioBean getUsuario(@PathVariable int idTipoUsuario) {
		
		if (genericService.get(TipoUsuarioBean.class,idTipoUsuario) == null) {
			throw new BeanNotFoundException("Tipo de usuario con el id - "+ idTipoUsuario +" no encontrado.");
		}
		return genericService.get(TipoUsuarioBean.class, idTipoUsuario);
	}

	@GetMapping("/tipousuarios")
	public List<TipoUsuarioBean> getAllUsuarios() {
		return (List<TipoUsuarioBean>) genericService.getAll(TipoUsuarioBean.class);
	}

	@PostMapping("/tipousuarios")
	public ResponseBean addTipoUsuario(@RequestBody TipoUsuarioBean oTipoUsuario) {
		return new ResponseBean(200,String.valueOf(genericService.save(oTipoUsuario)));
	}

	@PutMapping("/tipousuarios")
	public ResponseBean updateBean(@RequestBody TipoUsuarioBean oTipoUsuario) {

		// throw exception if null
		if (genericService.get(TipoUsuarioBean.class, oTipoUsuario.getId()) == null) {
			throw new BeanNotFoundException("Tipo de usuario con el id - " + oTipoUsuario.getId()+" no encontrado.");
		}
		
		return new ResponseBean(200,genericService.saveOrUpdate(oTipoUsuario));
	}

	@DeleteMapping("/tipousuarios/{idTipoUsuario}")
	public ResponseBean deleteCustomer(@PathVariable int idTipoUsuario) {

		TipoUsuarioBean oTipoUsuario = genericService.get(TipoUsuarioBean.class, idTipoUsuario);

		// throw exception if null
		if (oTipoUsuario == null) {
			throw new BeanNotFoundException("Tipo de usuario con el id - " + idTipoUsuario +" no encontrado.");
		}

		genericService.delete(oTipoUsuario);

		return new ResponseBean(200,"Tipo usuario con id - " + idTipoUsuario+" borrado.");
	}
}
