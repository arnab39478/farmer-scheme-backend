package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.BiddingRequest;

@Repository
public class BiddingRequestRepoImpl extends GenericRepoImpl implements BiddingRequestRepo{
	
	@Override
	public List<BiddingRequest> fetchBiddingRequestsBySellRequestId(int id){
				
		String jpql="select br from BiddingRequest br join br.sellRequest sr where sr.requestId=:id order by br.amount desc";
		return entityManager.createQuery(jpql).setParameter("id", id).setMaxResults(3).getResultList();
		
	}
	
	@Override
	public List<BiddingRequest> fetchBiddingRequestByBidder(int id){
		
		String jpql="select br from BiddingRequest br join br.bidder b where b.emailId=:bid";
		return entityManager.createQuery(jpql).setParameter("bid", id).getResultList();
	}
	
	@Override
	public int fetchHighestBidForSellRequest(int id){
		
		return (int) entityManager.createQuery("select max(br.amount) from BiddingRequest br join br.sellRequest sr where sr.id=:id")
				.setParameter("id", id).getSingleResult();
	}
	
	@Override
	public List<BiddingRequest> getCropsSoldToBidder(int id){
		
		String jpql="select br from BiddingRequest br join br.sellRequest sr where br.finalStatus=:status and sr.farmer.id=:id";
		return entityManager.createQuery(jpql).setParameter("status",'Y').setParameter("id", id).getResultList();
	}

}
