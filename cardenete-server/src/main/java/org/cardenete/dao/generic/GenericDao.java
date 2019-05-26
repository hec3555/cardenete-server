package org.cardenete.dao.generic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDao implements GenericDaoInterface {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public <T> T getAll(final Class<T> type) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.createQuery("FROM  " + type.getSimpleName()).getResultList();
	}

	@Override
	public <T> T get(final Class<T> type, final int id) {
		return sessionFactory.getCurrentSession().get(type, id);
	}

	@Override
	public <T> String saveOrUpdate(final T o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
		return "Updated";
	}

	@Override
	public <T> String delete(final T o) {
		sessionFactory.getCurrentSession().delete(o);
		return "Deleted";
	}

	@Override
	public <T> int save(final T o) {
		return  (Integer) sessionFactory.getCurrentSession().save(o);
	}

}
