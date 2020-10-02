package com.lti.dto;

import java.time.LocalDate;

public class CropDetails {
	
	private int farmerId;
	private String cropType;
	private String cropName;
	private String fertilizerType;
	private String quantity;
	private int basePrice;
	private LocalDate sellingDeadline;
	
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public String getCropType() {
		return cropType;
	}
	public String getCropName() {
		return cropName;
	}
	public String getFertilizerType() {
		return fertilizerType;
	}
	public String getQuantity() {
		return quantity;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public LocalDate getSellingDeadline() {
		return sellingDeadline;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public void setFertilizerType(String fertilizerType) {
		this.fertilizerType = fertilizerType;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public void setSellingDeadline(LocalDate sellingDeadline) {
		this.sellingDeadline = sellingDeadline;
	}
	
	

}
