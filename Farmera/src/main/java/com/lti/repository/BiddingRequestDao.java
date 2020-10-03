package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;

@Component("brdao")
public class BiddingRequestDao extends GenericDaoImpl{
	
	public List<BiddingRequest> fetchBiddingRequestsForFarmerSellRequest(int id){
				
		String jpql="select br from BiddingRequest br join br.sellRequest sr where sr.farmer.id=:fid";
		return entityManager.createQuery(jpql).setParameter("fid", id).getResultList();
		
	}
	
	public List<BiddingRequest> fetchBiddingRequestByBidder(int id){
		
		String jpql="select br from BiddingRequest br join br.bidder b where b.emailId=:bid";
		return entityManager.createQuery(jpql).setParameter("bid", id).getResultList();
	}
	
	public BiddingRequest fetchHighestBidForSellRequest(int id){
		
		return (BiddingRequest) entityManager.createQuery("select br from BiddingRequest br join br.sellRequest sr where sr.id=:id order by br.amount desc")
				.setParameter("id", id)
				.setMaxResults(1)
				.getSingleResult();
	}
	
	
	

}
