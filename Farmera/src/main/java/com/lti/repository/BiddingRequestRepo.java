package com.lti.repository;

import java.util.List;

import com.lti.entity.BiddingRequest;

public interface BiddingRequestRepo extends GenericRepo{

	List<BiddingRequest> fetchBiddingRequestsBySellRequestId(int id);

	List<BiddingRequest> fetchBiddingRequestByBidder(int id);

	int fetchHighestBidForSellRequest(int id);

	List<BiddingRequest> getCropsSoldToBidder(int id);

}