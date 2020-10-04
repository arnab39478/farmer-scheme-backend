package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lti.entity.SellRequest;

@Component("srdao")
public class SellRequestDao extends GenericDaoImpl {
	
	public List<SellRequest> fetchSellRequestsByFarmer(int id){		//Fetch Unsold Crops

		String jpql="select sr from SellRequest sr join sr.farmer f where f.id=:id";
		return entityManager.createQuery(jpql).setParameter("id",id).getResultList();
	}
	
	public List<SellRequest> fetchSellRequestsBidByBidder(String email){
		
		String jpql="select sr from SellRequest sr join sr.biddingRequest br where br.bidder.emailId=:em";
		return entityManager.createQuery(jpql).setParameter("em", email).getResultList();
	}
	
	public List<SellRequest> fetchCropSellRequests(){
		String jpql="select sr from SellRequest sr";
		return entityManager.createQuery(jpql).getResultList();
	}

}
