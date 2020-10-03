package com.lti.dto;

public class BidDetails {
	
	private int bidderId;
	private int sellRequestId;
	private int amount;
	public int getBidderId() {
		return bidderId;
	}
	public int getSellRequestId() {
		return sellRequestId;
	}
	public int getAmount() {
		return amount;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public void setSellRequestId(int sellRequestId) {
		this.sellRequestId = sellRequestId;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
