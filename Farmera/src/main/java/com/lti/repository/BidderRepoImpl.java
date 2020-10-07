package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BidderRepoImpl extends GenericRepoImpl implements BidderRepo {
	
	@Override
	public boolean isBidderRegistered(String email) {
		return (Long)
				entityManager
				.createQuery("select count(b.id) from Bidder b where b.emailId = :em")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	} 
	
	@Override
	public boolean isBidderPresent(String email, String password) {
		return (Long)
				entityManager
				.createQuery("select count(b.id) from Bidder b where b.emailId = :em and b.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult() == 1 ? true : false;
	} 
	
	@Override
	public int findByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select b.id from Bidder b where b.emailId = :em and b.password = :pw")
		        .setParameter("em", email)
		        .setParameter("pw", password)
		        .getSingleResult();
	}

}
