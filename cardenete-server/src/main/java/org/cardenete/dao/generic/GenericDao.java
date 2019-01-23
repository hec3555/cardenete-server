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
	public <T> T getAll(Class<T> type) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.createQuery("FROM  " + type.getSimpleName()).getResultList();
	}

	@Override
	public <T> T get(Class<T> type, int id) {
		return sessionFactory.getCurrentSession().get(type, id);
	}

	@Override
	public <T> String saveOrUpdate(T o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
		return "Updated";
	}

	@Override
	public <T> String delete(T o) {
		sessionFactory.getCurrentSession().delete(o);
		return "Deleted";
	}

	@Override
	public <T> int save(T o) {
		return  (Integer) sessionFactory.getCurrentSession().save(o);
	}

}
