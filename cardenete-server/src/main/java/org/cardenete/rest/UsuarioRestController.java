package org.cardenete.rest;

import org.cardenete.entity.UsuarioBean;
import org.cardenete.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardenete")
public class UsuarioRestController {
	@Autowired
	private GenericService genericService;
	
	@GetMapping("/usuario/{idUsuario}")
	public UsuarioBean oUsuario(@PathVariable int idUsuario){
		return genericService.get(UsuarioBean.class, idUsuario);
	}
}
