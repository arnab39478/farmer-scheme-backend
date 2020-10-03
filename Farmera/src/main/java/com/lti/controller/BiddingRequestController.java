package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BidDetails;
import com.lti.dto.CropForSale;
import com.lti.dto.CropList;
import com.lti.dto.CurrentBidStatus;
import com.lti.dto.Status;
import com.lti.exception.BiddingRequestServiceException;
import com.lti.service.BiddingRequestService;

@RestController
@CrossOrigin
public class BiddingRequestController {
	
	@Autowired
	private BiddingRequestService biddingRequestService;
	
	@GetMapping(path = "/after-login-bidder")
	public CropList viewCropsForBidding() {
		
		List<CropForSale> list=biddingRequestService.viewCropsForSale();
		CropList listOfCrops=new CropList();
		listOfCrops.setStatus(true);
		listOfCrops.setStatusMessage("Crops Available!");
		listOfCrops.setCropForSale(list);
		return listOfCrops;
	}
	
	@GetMapping(path = "/view-current-bid")
	public CurrentBidStatus obtainCurrentBid(@RequestParam("sellRequestId") int sellRequestId) {
		
		CurrentBidStatus status=new CurrentBidStatus();
		try {
			int currentBidAmount = biddingRequestService.fetchCurrentBid(sellRequestId);
			status.setStatus(true);
			status.setStatusMessage("Bid details available!");
			status.setAmount(currentBidAmount);
			return status;
		}
		catch(BiddingRequestServiceException e) {
			status.setStatus(false);
			status.setStatusMessage("No bids available!");
			return status;
		}	
				
	}
	
	@PostMapping(path = "/place-bid")
	public Status placeBiddingRequest(@RequestBody BidDetails bidDetails) {
		try {
			biddingRequestService.placeBid(bidDetails);
			Status status = new Status();
			status.setStatus(true);
			status.setStatusMessage("Bid Placed!");
		    return status;
		}
		catch (BiddingRequestServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}

}
