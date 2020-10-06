package com.lti.dto;

import java.time.LocalDate;

public class Crop {
	private int requestId;
	private LocalDate biddingDeadline;
	public int getRequestId() {
		return requestId;
	}
	public LocalDate getBiddingDeadline() {
		return biddingDeadline;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public void setBiddingDeadline(LocalDate biddingDeadline) {
		this.biddingDeadline = biddingDeadline;
	}
	

}
