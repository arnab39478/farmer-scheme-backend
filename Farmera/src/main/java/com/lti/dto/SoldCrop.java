package com.lti.dto;

import java.time.LocalDate;

public class SoldCrop {
	
	private int sellRequestId;
	private String cropName;
	private String quantity;
	private int basePrice;
	private int soldPrice;
	private LocalDate soldDate;
	public int getSellRequestId() {
		return sellRequestId;
	}
	public String getCropName() {
		return cropName;
	}
	public String getQuantity() {
		return quantity;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public int getSoldPrice() {
		return soldPrice;
	}
	public void setSellRequestId(int sellRequestId) {
		this.sellRequestId = sellRequestId;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}
	public LocalDate getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}
	

}
