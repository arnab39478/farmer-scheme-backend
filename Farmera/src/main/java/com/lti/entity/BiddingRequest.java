package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Bidding_Request")
public class BiddingRequest {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "bidreq")
	@SequenceGenerator(name= "bidreq", sequenceName = "bidding_request_seq", allocationSize= 1)
	@Column(name="bid_id")
	private int id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Bidder_Id")
	private Bidder bidder;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Farmer_SellRequestId")
	private SellRequest sellRequest;	

	@Column(name="bid_amount")
	private int amount;

	@Column(name="Bid_Date")
	private LocalDate bidDate;
	
	@Column(name = "Approved_Status")
	private char approvedStatus;

	@Column(name="Final_Status")
	private char finalStatus;

	public int getId() {
		return id;
	}

	public Bidder getBidder() {
		return bidder;
	}

	public SellRequest getSellRequest() {
		return sellRequest;
	}

	public int getAmount() {
		return amount;
	}

	public LocalDate getBidDate() {
		return bidDate;
	}

	public char getApprovedStatus() {
		return approvedStatus;
	}

	public char getFinalStatus() {
		return finalStatus;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public void setSellRequest(SellRequest sellRequest) {
		this.sellRequest = sellRequest;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setBidDate(LocalDate bidDate) {
		this.bidDate = bidDate;
	}

	public void setApprovedStatus(char approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	public void setFinalStatus(char finalStatus) {
		this.finalStatus = finalStatus;
	}

	

	

}