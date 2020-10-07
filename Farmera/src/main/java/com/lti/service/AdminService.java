package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

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
	
	@Autowired
	private EmailService emailService;
	
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
		
		Farmer farmer=aDao.fetchById(Farmer.class, farmerId);
		farmer.setApprovedStatus('Y');
		aDao.save(farmer);
	}
	
	public void approveBidder(int bidderId){
		
		Bidder bidder=aDao.fetchById(Bidder.class, bidderId);
		bidder.setApprovedStatus('Y');
		aDao.save(bidder);
	}
	
	public void approveSellRequest(int requestId){
		
		SellRequest sellRequest=aDao.fetchById(SellRequest.class, requestId);
		sellRequest.setApprovedStatus('Y');
		sellRequest.setBiddingStatus('O');
		aDao.save(sellRequest);
	}
	
	public void approveBiddingRequest(int requestId) {
		
		BiddingRequest biddingRequest=aDao.fetchById(BiddingRequest.class, requestId);
		if(biddingRequest.getApprovedStatus()=='Y')
			throw new AdminServiceException("Request already approved!");
		biddingRequest.setApprovedStatus('Y');
		aDao.save(biddingRequest);
	}
	
	public void setBiddingDeadlineForCrop(int sellRequestId, LocalDate biddingDeadline) {
		
		SellRequest sellRequest=aDao.fetchById(SellRequest.class, sellRequestId);
		if(sellRequest.getSellingDeadline().compareTo(biddingDeadline)<0 || sellRequest.getRequestDate().compareTo(biddingDeadline)>0)
			throw new AdminServiceException("Enter proper bidding deadline!");
		sellRequest.setBiddingStatus('O');
		sellRequest.setBiddingDeadline(biddingDeadline);
		aDao.save(sellRequest);
		
	}
	
	public Admin login(String email, String password) {
		try { 
			return aDao.fetchByEmailAndPassword(email, password);		

		} catch (NoResultException e) {
			throw new AdminServiceException("Invalid Credentials!");			
		}
	}
	
	public void endBiddingForCrop(int sellRequestId) {
		SellRequest sellRequest=aDao.fetchById(SellRequest.class, sellRequestId);
		BiddingRequest biddingRequest=aDao.fetchWinningBid(sellRequestId);
		biddingRequest.setFinalStatus('Y');
		aDao.save(biddingRequest);
		//emailService.sendMailForWinningBid(biddingRequest.getBidder());
		sellRequest.setBiddingStatus('C');
		sellRequest.setBiddingDeadline(LocalDate.now());
		aDao.save(sellRequest);
		//emailService.sendMailForSoldCrop(sellRequest.getFarmer());
	}
		

}
