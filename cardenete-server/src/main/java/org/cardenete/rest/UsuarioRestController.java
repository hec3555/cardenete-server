package org.cardenete.rest;

import java.util.List;

import org.cardenete.entity.UsuarioBean;
import org.cardenete.service.generic.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardenete")
public class UsuarioRestController {
	@Autowired
	private GenericServiceInterface genericService;
	
	@GetMapping("/usuarios/{idUsuario}")
	public UsuarioBean getUsuario(@PathVariable int idUsuario){
		return genericService.get(UsuarioBean.class, idUsuario);
	}
	
	@GetMapping("/usuarios")
	public List<UsuarioBean> getAllUsuarios(){
		return (List<UsuarioBean>) genericService.getAll(UsuarioBean.class);
	}
}
