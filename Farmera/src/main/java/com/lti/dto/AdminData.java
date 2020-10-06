package com.lti.dto;

import java.util.List;

import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;

public class AdminData extends Status {
	private List<Farmer> farmerRegistrationRequest;
	private List<Bidder> bidderRegistrationRequest;
	private List<SellRequest> cropSellRequest;
	private List<BiddingRequest> biddingRequest;
	public List<Farmer> getFarmerRegistrationRequest() {
		return farmerRegistrationRequest;
	}
	public List<Bidder> getBidderRegistrationRequest() {
		return bidderRegistrationRequest;
	}
	public List<SellRequest> getCropSellRequest() {
		return cropSellRequest;
	}
	public List<BiddingRequest> getBiddingRequest() {
		return biddingRequest;
	}
	public void setFarmerRegistrationRequest(List<Farmer> farmerRegistrationRequest) {
		this.farmerRegistrationRequest = farmerRegistrationRequest;
	}
	public void setBidderRegistrationRequest(List<Bidder> bidderRegistrationRequest) {
		this.bidderRegistrationRequest = bidderRegistrationRequest;
	}
	public void setCropSellRequest(List<SellRequest> cropSellRequest) {
		this.cropSellRequest = cropSellRequest;
	}
	public void setBiddingRequest(List<BiddingRequest> biddingRequest) {
		this.biddingRequest = biddingRequest;
	}
	
}
