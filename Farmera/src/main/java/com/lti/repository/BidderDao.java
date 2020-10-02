package com.lti.repository;

import org.springframework.stereotype.Component;

@Component("bDao")
public class BidderDao extends GenericDaoImpl {
	
	public int findByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select b.id from Bidder b where b.emailId = :em and b.password = :pw")
		        .setParameter("em", email)
		        .setParameter("pw", password)
		        .getSingleResult();
	}

}
