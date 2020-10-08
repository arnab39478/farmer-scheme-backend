package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.BidDetails;
import com.lti.dto.BidForCrop;
import com.lti.dto.CropForSale;
import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.SellRequest;
import com.lti.exception.BiddingRequestServiceException;
import com.lti.repository.BidderRepo;
import com.lti.repository.BiddingRequestRepo;
import com.lti.repository.SellRequestRepo;

@Service
public class BiddingRequestServiceImpl implements BiddingRequestService {
	
	@Autowired
	private BidderRepo bRepo;
	
	@Autowired
	private SellRequestRepo srRepo;
	
	@Autowired
	private BiddingRequestRepo brRepo;
		
	@Override
	public List<CropForSale> viewCropsForSale(){
		
		List<CropForSale> crops=new ArrayList<>();
		List<SellRequest> sellRequests=srRepo.fetchCropSellRequests();
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
	
	@Override
	public int fetchCurrentBid(int sellRequestId) {

		return brRepo.fetchHighestBidForSellRequest(sellRequestId);
				
	}
	
	@Override
	public List<BidForCrop> viewPreviousBidsForCrop(int sellRequestId){
		
		List<BidForCrop> bids=new ArrayList<>();
		List<BiddingRequest> biddingRequests=brRepo.fetchBiddingRequestsBySellRequestId(sellRequestId);
		for(BiddingRequest br: biddingRequests)
		{
			BidForCrop bid=new BidForCrop();
			bid.setBidId(br.getId());
			bid.setBidDate(br.getBidDate());
			bid.setAmount(br.getAmount());
			bid.setCropName(br.getSellRequest().getCropName());
			bid.setSellRequestId(br.getSellRequest().getRequestId());
			bids.add(bid);
		}
		return bids;
	}
	
	@Override
	public void placeBid(BidDetails bidDetails) {
		
		Bidder bidder=bRepo.fetchById(Bidder.class, bidDetails.getBidderId());
		if(bidder.getApprovedStatus()=='N')
			throw new BiddingRequestServiceException("Bidder not approved!");
		SellRequest sellRequest=srRepo.fetchById(SellRequest.class, bidDetails.getSellRequestId());
		if(sellRequest.getBiddingDeadline().compareTo(LocalDate.now())<0)
			throw new BiddingRequestServiceException("Bidding deadline exceeded!");
		if(sellRequest.getBiddingStatus()=='C')
			throw new BiddingRequestServiceException("Bidding for crop has been closed! Please contact admin for more details!");
		BiddingRequest biddingRequest=new BiddingRequest();
		biddingRequest.setBidDate(LocalDate.now());
		biddingRequest.setAmount(bidDetails.getAmount());
		biddingRequest.setBidder(bidder);
		biddingRequest.setSellRequest(sellRequest);
		biddingRequest.setFinalStatus('N');
		biddingRequest.setApprovedStatus('N');
		
		brRepo.save(biddingRequest);
		
	}

}
