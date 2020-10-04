package com.lti.dto;

import java.time.LocalDate;

public class BidForCrop {
	
	private int sellRequestId;
	private String cropName;
	private int bidId;
	private int amount;
	private LocalDate bidDate;
	public int getSellRequestId() {
		return sellRequestId;
	}
	public String getCropName() {
		return cropName;
	}
	public int getBidId() {
		return bidId;
	}
	public int getAmount() {
		return amount;
	}
	public LocalDate getBidDate() {
		return bidDate;
	}
	public void setSellRequestId(int sellRequestId) {
		this.sellRequestId = sellRequestId;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setBidDate(LocalDate bidDate) {
		this.bidDate = bidDate;
	}
	
	

}
