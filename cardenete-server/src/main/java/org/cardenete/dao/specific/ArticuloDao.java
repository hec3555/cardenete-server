package org.cardenete.dao.specific;

import java.util.List;

import org.cardenete.entity.ArticuloBean;

public interface ArticuloDao {
	public List<ArticuloBean> getAllBySeccion(int idSeccion);
	public List<ArticuloBean> getAllByUsuario(int idUsuario);
	public List<ArticuloBean> getAllByUsuarioAndSeccion(int idUsuario, int idSeccion);
}
