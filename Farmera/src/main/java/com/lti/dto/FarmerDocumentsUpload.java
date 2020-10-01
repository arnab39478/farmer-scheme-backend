package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class FarmerDocumentsUpload {
     
	private int id;
	private MultipartFile aadhar;
	private MultipartFile pan;
	private MultipartFile certificate;
	public int getId() {
		return id;
	}
	public MultipartFile getAadhar() {
		return aadhar;
	}
	public MultipartFile getPan() {
		return pan;
	}
	public MultipartFile getCertificate() {
		return certificate;
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
	public void setCertificate(MultipartFile certificate) {
		this.certificate = certificate;
	}
	
	
	
	
	
}
