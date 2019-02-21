package org.cardenete.dao.specific;

import java.util.List;

import org.cardenete.entity.UsuarioBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UsuarioBean login(String user, String pass) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UsuarioBean> theQuery = currentSession
				.createQuery("from UsuarioBean WHERE login = :login and pass = :pass", UsuarioBean.class);
		theQuery.setParameter("login", user);
		theQuery.setParameter("pass", pass);
		List<UsuarioBean> usuarioExists = theQuery.getResultList(); // creo una lista porque si hago el single result y no encuentra ningun usuario salta excepcion
		if(usuarioExists.isEmpty()) { // si la lista esta vacia devuelvo null y así en el rest trataremos el error de que no se ha loggeado con el mensaje que quiera
			return null;
		}
		UsuarioBean usuario = theQuery.getSingleResult(); // si llega aquí, es que si que lo ha encontrado y devolvemos el usuario que va a loggearse
		return usuario;
	}

}
