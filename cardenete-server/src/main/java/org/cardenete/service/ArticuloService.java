package org.cardenete.service;

import java.util.List;

import org.cardenete.entity.ArticuloBean;

public interface ArticuloService {
	
	public List<ArticuloBean> getAllBySeccion(int idSeccion);
	
	public List<ArticuloBean> getAllByUsuario(int idUsuario);
	
	public List<ArticuloBean> getAllByUsuarioAndSeccion(int idUsuario, int idSeccion);
	
}
