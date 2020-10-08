package com.lti.dto;

import java.time.LocalDate;

public class CropForSale {
	
	private int cropId;
	private String cropType;
	private String cropName;
	private int basePrice;
	private int currentBid;
	private LocalDate biddingDeadline;
	public int getCropId() {
		return cropId;
	}
	public String getCropType() {
		return cropType;
	}
	public String getCropName() {
		return cropName;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public int getCurrentBid() {
		return currentBid;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public void setCurrentBid(int currentBid) {
		this.currentBid = currentBid;
	}
	public LocalDate getBiddingDeadline() {
		return biddingDeadline;
	}
	public void setBiddingDeadline(LocalDate biddingDeadline) {
		this.biddingDeadline = biddingDeadline;
	}
	
	
	

}
