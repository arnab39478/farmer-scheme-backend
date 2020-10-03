package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.BidDetails;
import com.lti.dto.CropForSale;
import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.SellRequest;
import com.lti.repository.BidderDao;
import com.lti.repository.BiddingRequestDao;
import com.lti.repository.SellRequestDao;

@Service
public class BiddingRequestService {
	
	@Autowired
	private BidderDao bDao;
	
	@Autowired
	private SellRequestDao srDao;
	
	@Autowired
	private BiddingRequestDao brDao;
		
	public List<CropForSale> viewCropsForSale(){
		
		List<CropForSale> crops=new ArrayList<>();
		List<SellRequest> sellRequests=srDao.fetchCropSellRequests();
		for(SellRequest sr: sellRequests)
		{
			CropForSale crop=new CropForSale();
			crop.setCropId(sr.getRequestId());
			crop.setCropType(sr.getCropType());
			crop.setCropName(sr.getCropName());
			crop.setBasePrice(sr.getBasePrice());
			crops.add(crop);
		}
		return crops;	
	}
	
	public int fetchCurrentBid(int sellRequestId) {

		return brDao.fetchHighestBidForSellRequest(sellRequestId);
				
	}
	
	public void placeBid(BidDetails bidDetails) {
		
		Bidder bidder=bDao.fetchById(Bidder.class, bidDetails.getBidderId());
		SellRequest sellRequest=srDao.fetchById(SellRequest.class, bidDetails.getSellRequestId());
		
		BiddingRequest biddingRequest=new BiddingRequest();
		biddingRequest.setBidDate(LocalDate.now());
		biddingRequest.setAmount(bidDetails.getAmount());
		biddingRequest.setBidder(bidder);
		biddingRequest.setSellRequest(sellRequest);
		biddingRequest.setFinalStatus('N');
		biddingRequest.setApprovedStatus('Y');
		
		brDao.save(biddingRequest);
		
	}
	
	

}
