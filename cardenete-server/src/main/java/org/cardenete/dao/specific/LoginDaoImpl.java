package org.cardenete.dao.specific;

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
		UsuarioBean usuario = theQuery.getSingleResult();
		return usuario;
	}

}
