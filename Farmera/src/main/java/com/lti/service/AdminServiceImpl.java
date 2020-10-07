package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;
import com.lti.exception.AdminServiceException;
import com.lti.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo aRepo;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public List<Farmer> getAllFarmerRequests(){		
		
		return aRepo.getAllFarmers();		
	}
	
	@Override
	public List<Bidder> getAllBidderRequests(){		
		
		return aRepo.getAllBidders();		
	}
	
	@Override
	public List<SellRequest> getAllSellRequests(){
		
		return aRepo.getAllSellRequests();
	}
	
	@Override
	public List<BiddingRequest> getAllBiddingRequests(){
		
		return aRepo.getAllBiddingRequests();
	}
	
	@Override
	public void approveFarmer(int farmerId){
		
		Farmer farmer=aRepo.fetchById(Farmer.class, farmerId);
		farmer.setApprovedStatus('Y');
		aRepo.save(farmer);
	}
	
	@Override
	public void approveBidder(int bidderId){
		
		Bidder bidder=aRepo.fetchById(Bidder.class, bidderId);
		bidder.setApprovedStatus('Y');
		aRepo.save(bidder);
	}
	
	@Override
	public void approveSellRequest(int requestId){
		
		SellRequest sellRequest=aRepo.fetchById(SellRequest.class, requestId);
		sellRequest.setApprovedStatus('Y');
		sellRequest.setBiddingStatus('O');
		aRepo.save(sellRequest);
	}
	
	@Override
	public void approveBiddingRequest(int requestId) {
		
		BiddingRequest biddingRequest=aRepo.fetchById(BiddingRequest.class, requestId);
		if(biddingRequest.getApprovedStatus()=='Y')
			throw new AdminServiceException("Request already approved!");
		biddingRequest.setApprovedStatus('Y');
		aRepo.save(biddingRequest);
	}
	
	@Override
	public void setBiddingDeadlineForCrop(int sellRequestId, LocalDate biddingDeadline) {
		
		SellRequest sellRequest=aRepo.fetchById(SellRequest.class, sellRequestId);
		if(sellRequest.getSellingDeadline().compareTo(biddingDeadline)<0 || sellRequest.getRequestDate().compareTo(biddingDeadline)>0)
			throw new AdminServiceException("Enter proper bidding deadline!");
		sellRequest.setBiddingStatus('O');
		sellRequest.setBiddingDeadline(biddingDeadline);
		aRepo.save(sellRequest);
		
	}
	
	@Override
	public Admin login(String email, String password) {
		try { 
			return aRepo.fetchByEmailAndPassword(email, password);		

		} catch (NoResultException e) {
			throw new AdminServiceException("Invalid Credentials!");			
		}
	}
	
	@Override
	public void endBiddingForCrop(int sellRequestId) {
		SellRequest sellRequest=aRepo.fetchById(SellRequest.class, sellRequestId);
		BiddingRequest biddingRequest=aRepo.fetchWinningBid(sellRequestId);
		biddingRequest.setFinalStatus('Y');
		aRepo.save(biddingRequest);
		//emailService.sendMailForWinningBid(biddingRequest.getBidder());
		sellRequest.setBiddingStatus('C');
		sellRequest.setBiddingDeadline(LocalDate.now());
		aRepo.save(sellRequest);
		//emailService.sendMailForSoldCrop(sellRequest.getFarmer());
	}
	
}
