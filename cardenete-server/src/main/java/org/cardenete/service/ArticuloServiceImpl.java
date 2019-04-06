package org.cardenete.service;

import java.util.List;

import org.cardenete.dao.specific.ArticuloDao;
import org.cardenete.entity.ArticuloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	ArticuloDao articuloDao;
	
	@Transactional
	public List<ArticuloBean> getAllBySeccion(int idSeccion) {
		return articuloDao.getAllBySeccion(idSeccion);
	}

	@Transactional
	public List<ArticuloBean> getAllByUsuario(int idUsuario) {
		return articuloDao.getAllByUsuario(idUsuario);
	}

	@Transactional
	public List<ArticuloBean> getAllBySeccionAndUsuario(int idSeccion, int idUsuario) {
		return articuloDao.getAllBySeccionAndUsuario(idSeccion, idUsuario);
	}

}
