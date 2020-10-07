package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.SellRequest;

@Repository
public class SellRequestRepoImpl extends GenericRepoImpl implements SellRequestRepo {
	
	@Override
	public List<SellRequest> fetchSellRequestsByFarmer(int id){		//Fetch Unsold Crops

		String jpql="select sr from SellRequest sr join sr.farmer f where f.id=:id";
		return entityManager.createQuery(jpql).setParameter("id",id).getResultList();
	}
	
	@Override
	public List<SellRequest> fetchSellRequestsBidByBidder(String email){
		
		String jpql="select sr from SellRequest sr join sr.biddingRequest br where br.bidder.emailId=:em";
		return entityManager.createQuery(jpql).setParameter("em", email).getResultList();
	}
	
	@Override
	public List<SellRequest> fetchCropSellRequests(){
		String jpql="select sr from SellRequest sr where sr.biddingStatus=:status";
		return entityManager.createQuery(jpql).setParameter("status",'O').getResultList();
	}

}
