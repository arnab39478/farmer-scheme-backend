package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminData;
import com.lti.dto.Status;
import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping(path = "/view-all-requests")
	public AdminData viewAllRequests() {
		
		AdminData adminData=new AdminData();
		List<Farmer> farmerList=adminService.getAllFarmerRequests();
		List<Bidder> bidderList=adminService.getAllBidderRequests();
		List<SellRequest> sellRequestList=adminService.getAllSellRequests();
		List<BiddingRequest> biddingRequestList=adminService.getAllBiddingRequests();
		
		adminData.setFarmerRegistrationRequest(farmerList);
		adminData.setBidderRegistrationRequest(bidderList);
		adminData.setCropSellRequest(sellRequestList);
		adminData.setBiddingRequest(biddingRequestList);
		
		return adminData;		
		
	}
	
	@GetMapping(path = "/approve-farmer")
	public Status approveFarmer(@RequestParam("farmerId") int farmerId) {
		
		Status status=new Status();
		adminService.approveFarmer(farmerId);
		status.setStatus(true);
		status.setStatusMessage("Farmer Approved!");
		return status;		
	}
	
	@GetMapping(path = "/approve-bidder")
	public Status approveBidder(@RequestParam("bidderId") int bidderId) {
		
		Status status=new Status();
		adminService.approveBidder(bidderId);
		status.setStatus(true);
		status.setStatusMessage("Bidder Approved!");
		return status;		
	}
	
	@GetMapping(path = "/approve-sell-request")
	public Status approveSellRequest(@RequestParam("requestId") int requestId) {
		
		Status status=new Status();
		adminService.approveSellRequest(requestId);
		status.setStatus(true);
		status.setStatusMessage("Sell Request Approved!");
		return status;		
	}
	
	@GetMapping(path = "/approve-bidding-request")
	public Status approveBiddingRequest(@RequestParam("requestId") int requestId) {
		
		Status status=new Status();
		adminService.approveBiddingRequest(requestId);
		status.setStatus(true);
		status.setStatusMessage("Bidding Request Approved!");
		return status;		
	}
	
}
