package org.cardenete.service.generic;

import org.cardenete.dao.generic.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenericService implements GenericServiceInterface {

	@Autowired
	GenericDao genericDao;
	
	@Transactional
	public <T> T getAll(final Class<T> type) {
		return  genericDao.getAll(type);
	}

	@Transactional
	public <T> T get(final Class<T> type, final int id) {
		return genericDao.get(type, id);
	}

	@Transactional
	public <T> String saveOrUpdate(final T o) {
		return genericDao.saveOrUpdate(o);
	}

	@Transactional
	public <T> String delete(final T o) {
		return genericDao.delete(o);
	}

	@Transactional
	public <T> int save(final T o) {
		return genericDao.save(o);
	}

}
