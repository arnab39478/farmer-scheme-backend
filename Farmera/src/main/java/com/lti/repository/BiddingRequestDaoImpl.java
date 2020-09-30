package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;

@Component("brdao")
public class BiddingRequestDaoImpl extends GenericDaoImpl implements BiddingRequestDao {
	
	public List<BiddingRequest> fetchBiddingRequestsForFarmerSellRequest(String email){
				
		String jpql="select br from BiddingRequest br join br.sellRequest sr where sr.farmer.emailId=:em";
		return entityManager.createQuery(jpql).setParameter("em", email).getResultList();
		
	}
	
	public List<BiddingRequest> fetchBiddingRequestByBidder(String email){
		
		String jpql="select br from BiddingRequest br join br.bidder b where b.emailId=:em";
		return entityManager.createQuery(jpql).setParameter("em", email).getResultList();
	}

}
