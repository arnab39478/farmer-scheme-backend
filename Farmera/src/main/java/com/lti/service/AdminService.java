package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;

public interface AdminService {

	List<Farmer> getAllFarmerRequests();

	List<Bidder> getAllBidderRequests();

	List<SellRequest> getAllSellRequests();

	List<BiddingRequest> getAllBiddingRequests();

	void approveFarmer(int farmerId);

	void approveBidder(int bidderId);

	void approveSellRequest(int requestId);

	void approveBiddingRequest(int requestId);

	void setBiddingDeadlineForCrop(int sellRequestId, LocalDate biddingDeadline);

	Admin login(String email, String password);

	void endBiddingForCrop(int sellRequestId);

}