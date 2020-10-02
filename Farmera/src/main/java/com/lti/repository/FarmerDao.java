package com.lti.repository;

import org.springframework.stereotype.Component;

@Component("fdao")
public class FarmerDao extends GenericDaoImpl {
	
	public boolean isFarmerRegistered(String email) {
		return (Long)
				entityManager
				.createQuery("select count(f.id) from Farmer f where f.emailId = :em")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}
	
	public boolean isFarmerPresent(String email, String password) {
		return (Long)
				entityManager
				.createQuery("select count(f.id) from Farmer f where f.emailId = :em and f.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult() == 1 ? true : false;
	}
	
	public int findByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select f.id from Farmer f where f.emailId = :em and f.password = :pw")
		        .setParameter("em", email)
		        .setParameter("pw", password)
		        .getSingleResult();
	}

	
	 
	
	

}
