package com.lti.repository;

import org.springframework.stereotype.Component;

@Component("fdao")
public class FarmerDao extends GenericDaoImpl {
	
	public int findByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select f.id from Farmer f where f.emailId = :em and f.password = :pw")
		        .setParameter("em", email)
		        .setParameter("pw", password)
		        .getSingleResult();
	}

	
	 
	
	

}
