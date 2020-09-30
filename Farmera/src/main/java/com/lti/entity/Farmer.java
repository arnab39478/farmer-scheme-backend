package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Farmer {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "farmerseq")
	@SequenceGenerator(name= "farmerseq", sequenceName = "farmer_seq", allocationSize= 1)
	@Column(name = "Farmer_Id")
	private int id;
	
	@Column(name = "Full_Name")
	private String fullName;

	@Column(name = "Contact_No")
	private String contactNo;

	@Column(name = "Email_Id")
	private String emailId;

	private String address;
	private String city;
	private String state;

	@Column(name = "Pin_Code")
	private int pinCode;

	@Column(name = "Land_Address")
	private String landAddress;

	@Column(name = "Land_Area")
	private String landArea;

	@Column(name = "Land_Pin_Code")
	private int landPincode;

	@Column(name = "Account_No")
	private long accountNo;

	private String ifsc;
	private String aadhar;
	private String pan;
	private String certificate;
	private String password;

	@Column(name = "Approved_Status")
	private char approvedStatus;

	@OneToMany(mappedBy = "farmer", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Column(name = "Sell_Requests")
	private List<SellRequest> sellRequest;

	public String getFullName() {
		return fullName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public String getLandAddress() {
		return landAddress;
	}

	public String getLandArea() {
		return landArea;
	}

	public int getLandPincode() {
		return landPincode;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public String getAadhar() {
		return aadhar;
	}

	public String getPan() {
		return pan;
	}

	public String getCertificate() {
		return certificate;
	}

	public String getPassword() {
		return password;
	}

	public char getApprovedStatus() {
		return approvedStatus;
	}

	public List<SellRequest> getSellRequest() {
		return sellRequest;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}

	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}

	public void setLandPincode(int landPincode) {
		this.landPincode = landPincode;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setApprovedStatus(char approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	public void setSellRequest(List<SellRequest> sellRequest) {
		this.sellRequest = sellRequest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}