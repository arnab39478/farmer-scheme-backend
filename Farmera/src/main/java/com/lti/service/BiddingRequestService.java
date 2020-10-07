package com.lti.service;

import java.util.List;

import com.lti.dto.BidDetails;
import com.lti.dto.BidForCrop;
import com.lti.dto.CropForSale;

public interface BiddingRequestService {

	List<CropForSale> viewCropsForSale();

	int fetchCurrentBid(int sellRequestId);

	List<BidForCrop> viewPreviousBidsForCrop(int sellRequestId);

	void placeBid(BidDetails bidDetails);

}