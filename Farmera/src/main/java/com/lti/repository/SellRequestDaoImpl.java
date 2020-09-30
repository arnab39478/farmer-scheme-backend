package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lti.entity.SellRequest;

@Component("srdao")
public class SellRequestDaoImpl extends GenericDaoImpl implements SellRequestDao {
	
	public List<SellRequest> fetchSellRequestsByFarmer(String email){

		String jpql="select sr from SellRequest sr join sr.farmer f where f.emailId=:em";
		return entityManager.createQuery(jpql).setParameter("em", email).getResultList();
	}
	
	public List<SellRequest> fetchSellRequestsBidByBidder(String email){
		
		String jpql="select sr from SellRequest sr join sr.biddingRequest br where br.bidder.emailId=:em";
		return entityManager.createQuery(jpql).setParameter("em", email).getResultList();
	}

}
