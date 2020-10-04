package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BidForCrop;
import com.lti.dto.BidList;
import com.lti.dto.CropForSale;
import com.lti.dto.CropList;
import com.lti.exception.BiddingRequestServiceException;
import com.lti.service.BiddingRequestService;
import com.lti.service.FarmerService;

@RestController
@CrossOrigin
public class MarketplaceController {
	
	@Autowired
	private FarmerService farmerService;
	
	@Autowired
	private BiddingRequestService biddingRequestService;
	
	@GetMapping(path = "/view-marketplace")
	public CropList viewUnsoldCrops(@RequestParam("farmerId") int farmerId) {
		
		List<CropForSale> list=farmerService.getCrops(farmerId);
		CropList listOfCrops=new CropList();
		listOfCrops.setStatus(true);
		listOfCrops.setStatusMessage("Bidding in Process!");
		listOfCrops.setCropForSale(list);
		return listOfCrops;
	}
	
	@GetMapping(path = "/view-previous-bids")
	public BidList viewPreviousBids(@RequestParam("sellRequestId") int sellRequestId) {
		
		BidList listOfBids=new BidList();
		
		try {
		List<BidForCrop> list=biddingRequestService.viewPreviousBidsForCrop(sellRequestId);
		listOfBids.setStatus(true);
		listOfBids.setStatusMessage("Bids available!");
		listOfBids.setBidForCrop(list);
		return listOfBids;
		}
		catch(BiddingRequestServiceException e) {
			listOfBids.setStatus(false);
			listOfBids.setStatusMessage("No Bids avaialable!");
			return listOfBids;
		}
		
				
	}

}
