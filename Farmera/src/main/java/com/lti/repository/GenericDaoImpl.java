package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("dao")
public class GenericDaoImpl implements GenericDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public <T> T save(Object obj) {
		return (T) entityManager.merge(obj) ;
	}

	@Transactional
	public <T> T fetchById(Class<T> cl, Object id) {
		return entityManager.find(cl, id);
	}



}