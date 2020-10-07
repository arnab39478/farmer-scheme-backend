package com.lti.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Component;

import com.lti.entity.Admin;
import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;

@Component("aDao")
public class AdminDao extends GenericDaoImpl {
	
	public List<Farmer> getAllFarmers(){
		
		return entityManager.createQuery("select f from Farmer f").getResultList();
	}
	
	public List<Bidder> getAllBidders(){
		
		return entityManager.createQuery("select b from Bidder b").getResultList();
	}
	
	public List<SellRequest> getAllSellRequests(){
		
		return entityManager.createQuery("select sr from SellRequest sr").getResultList();
	}
	
	public List<BiddingRequest> getAllBiddingRequests(){
		
		return entityManager.createQuery("select br from BiddingRequest br").getResultList();
	}

	public BiddingRequest fetchWinningBid(int id) {
		
		return (BiddingRequest) entityManager.createQuery("select br from BiddingRequest br join br.sellRequest sr where sr.requestId=:id order by br.amount desc")
				.setParameter("id",id).setMaxResults(1).getSingleResult();
		
	}

	public Admin fetchByEmailAndPassword(String email, String password) throws NoResultException {
		return (Admin) entityManager.createQuery("select a from Admin a where a.emailId =:email and a.password =:password")
				.setParameter("email",email).setParameter("password",password).getSingleResult();
	}
	
}
