package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Component;

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
	
	public void updateFarmerApprovedStatus(int id) {
		
		entityManager.createQuery("update Farmer f set f.approvedStatus=:status where f.id=:id").setParameter("status",'Y').setParameter("id",id);
	}
	
	public void updateBidderApprovedStatus(int id) {
		
		entityManager.createQuery("update Bidder b set b.approvedStatus=:status where b.id=:id").setParameter("status",'Y').setParameter("id",id);
	}
	
	public void updateSellRequestApprovedStatus(int id) {
		
		entityManager.createQuery("update SellRequest sr set sr.approvedStatus=:status where sr.requestId=:id").setParameter("status",'Y').setParameter("id",id);
	}
	
	public void updateBiddingRequestApprovedStatus(int id) {
		
		entityManager.createQuery("update BiddingRequest br set br.approvedStatus=:status where br.id=:id").setParameter("status",'Y').setParameter("id",id);
	
	}

}
