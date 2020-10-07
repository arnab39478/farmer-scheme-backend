package com.lti.repository;

import org.springframework.transaction.annotation.Transactional;

public interface GenericRepo {

	public <T> T save(Object obj);

	public <T> T fetchById(Class<T> cl, Object id);

}