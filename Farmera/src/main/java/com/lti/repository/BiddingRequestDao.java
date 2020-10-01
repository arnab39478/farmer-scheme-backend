package com.lti.repository;

import java.util.List;

import com.lti.entity.BiddingRequest;

public interface BiddingRequestDao {

	List<BiddingRequest> fetchBiddingRequestsForFarmerSellRequest(int id);

	List<BiddingRequest> fetchBiddingRequestByBidder(int id);

}