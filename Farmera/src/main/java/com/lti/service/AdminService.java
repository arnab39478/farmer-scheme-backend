package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;
import com.lti.exception.AdminServiceException;
import com.lti.repository.AdminDao;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao aDao;
	
	public List<Farmer> getAllFarmerRequests(){		
		
		return aDao.getAllFarmers();		
	}
	
	public List<Bidder> getAllBidderRequests(){		
		
		return aDao.getAllBidders();		
	}
	
	public List<SellRequest> getAllSellRequests(){
		
		return aDao.getAllSellRequests();
	}
	
	public List<BiddingRequest> getAllBiddingRequests(){
		
		return aDao.getAllBiddingRequests();
	}
	
	public void approveFarmer(int farmerId){
		
		aDao.updateFarmerApprovedStatus(farmerId);
	}
	
	public void approveBidder(int bidderId){
		
		aDao.updateBidderApprovedStatus(bidderId);
	}
	
	public void approveSellRequest(int requestId){
		
		aDao.updateSellRequestApprovedStatus(requestId);
	}
	
	public void approveBiddingRequest(int requestId) {
		
		aDao.updateBiddingRequestApprovedStatus(requestId);
	}
	
	public Admin login(String email, String Password) {
		try {
			return aDao.fetchById(Admin.class, email);
		}
		catch(EmptyResultDataAccessException e) {
			throw new AdminServiceException("Invalid Credentials!");		
		}
	}
		

}
