package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.UsuarioBean;
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
public class UsuarioRestController {
	@Autowired
	private GenericServiceInterface genericService;

	@GetMapping("/usuarios/{idUsuario}")
	public UsuarioBean getUsuario(@PathVariable int idUsuario) {
		return genericService.get(UsuarioBean.class, idUsuario);
	}

	@GetMapping("/usuarios")
	public List<UsuarioBean> getAllUsuarios() {
		return (List<UsuarioBean>) genericService.getAll(UsuarioBean.class);
	}

	@PostMapping("/usuarios")
	public int addUsuario(@RequestBody UsuarioBean oUsuario) {
		return genericService.save(oUsuario);
	}

	@PutMapping("/usuarios")
	public String updateBean(@RequestBody UsuarioBean oUsuario) {

		// throw exception if null
		if (genericService.get(UsuarioBean.class, oUsuario.getId()) == null) {
			throw new BeanNotFoundException("Usuario con el id: " + oUsuario.getId()+" no encontrado.");
		}

		return genericService.saveOrUpdate(oUsuario);
	}

	@DeleteMapping("/usuarios/{idUsuario}")
	public String deleteCustomer(@PathVariable int idUsuario) {

		UsuarioBean oUsuario = genericService.get(UsuarioBean.class, idUsuario);

		// throw exception if null
		if (oUsuario == null) {
			throw new BeanNotFoundException("Usuario con el id: " + idUsuario +" no encontrado.");
		}

		genericService.delete(oUsuario);

		return "Deleted user id - " + idUsuario;
	}

}
