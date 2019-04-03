package org.cardenete.dao.specific;

import java.util.List;

import org.cardenete.entity.ArticuloBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticuloDaoImpl implements ArticuloDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<ArticuloBean> getAllBySeccion(int idSeccion) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ArticuloBean> theQuery = currentSession
				.createQuery("from ArticuloBean WHERE id_seccion.id = :idSeccion", ArticuloBean.class);
		theQuery.setParameter("idSeccion", idSeccion);
		List<ArticuloBean> articulosBySeccion = theQuery.getResultList();
		if(articulosBySeccion.isEmpty()) {
			return null;
		}
		
		return articulosBySeccion;
	}

	public List<ArticuloBean> getAllByUsuario(int idUsuario) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ArticuloBean> theQuery = currentSession.createQuery("from ArticuloBean WHERE id_usuario.id = :idUsuario", ArticuloBean.class);
		theQuery.setParameter("idUsuario", idUsuario);
		List<ArticuloBean> articulos = theQuery.getResultList();
		return articulos;
	}

	public List<ArticuloBean> getAllByUsuarioAndSeccion(int idUsuario, int idSeccion) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ArticuloBean> theQuery = currentSession
				.createQuery("from ArticuloBean WHERE id_usuario.id = :idUsuario AND id_seccion.id = :idSeccion ", ArticuloBean.class);
		theQuery.setParameter("idUsuario", idUsuario);
		theQuery.setParameter("idSeccion", idSeccion);
		List<ArticuloBean> articulosByUsuarioAndSeccion= theQuery.getResultList();
		if(articulosByUsuarioAndSeccion.isEmpty()) {
			return null;
		}
		
		return articulosByUsuarioAndSeccion;
	}

}
