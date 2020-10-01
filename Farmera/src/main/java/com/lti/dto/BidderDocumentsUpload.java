package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class BidderDocumentsUpload {
	
	private int id;
	private MultipartFile aadhar;
	private MultipartFile pan;
	private MultipartFile traderLicense;
	public int getId() {
		return id;
	}
	public MultipartFile getAadhar() {
		return aadhar;
	}
	public MultipartFile getPan() {
		return pan;
	}
	public MultipartFile getTraderLicense() {
		return traderLicense;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAadhar(MultipartFile aadhar) {
		this.aadhar = aadhar;
	}
	public void setPan(MultipartFile pan) {
		this.pan = pan;
	}
	public void setTraderLicense(MultipartFile traderLicense) {
		this.traderLicense = traderLicense;
	}
	

}
