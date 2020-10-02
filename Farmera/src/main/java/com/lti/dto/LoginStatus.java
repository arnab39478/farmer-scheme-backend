package com.lti.dto;

public class LoginStatus extends Status {
    
	private int id;
	private String name;
	private boolean farmer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFarmer() {
		return farmer;
	}

	public void setFarmer(boolean farmer) {
		this.farmer = farmer;
	}
	
	
	
	
}
