package com.lti.dto;

import java.util.List;

public class BidList extends Status {
	
	List<BidForCrop> bidForCrop;

	public List<BidForCrop> getBidForCrop() {
		return bidForCrop;
	}

	public void setBidForCrop(List<BidForCrop> bidForCrop) {
		this.bidForCrop = bidForCrop;
	}
	

}
