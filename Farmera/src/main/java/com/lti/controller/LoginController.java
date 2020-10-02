package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.entity.Bidder;
import com.lti.entity.Farmer;
import com.lti.exception.BidderServiceException;
import com.lti.exception.FarmerServiceException;
import com.lti.service.BidderService;
import com.lti.service.FarmerService;

@RestController
@CrossOrigin
public class LoginController {
	
	
	@Autowired
	private FarmerService farmerService;
	
	@Autowired
	private BidderService bidderService;
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		LoginStatus loginStatus = new LoginStatus();
		
		int farmerPresent = farmerService.checkIfPresent(login.getEmail(), login.getPassword());
		int bidderPresent = bidderService.checkIfPresent(login.getEmail(), login.getPassword());
			
		if(farmerPresent==1) {
			
			try {
				Farmer farmer = farmerService.login(login.getEmail(), login.getPassword());
				loginStatus.setStatus(true);
				loginStatus.setName(farmer.getFullName());
				loginStatus.setId(farmer.getId());
				loginStatus.setStatusMessage("Login Successful!");
				return loginStatus;
					
			}
			catch(FarmerServiceException e1){
				loginStatus.setStatus(false);
				loginStatus.setStatusMessage("User not found!");
			}
			
		}
		else if(bidderPresent==1) {
			
			try {
				Bidder bidder = bidderService.login(login.getEmail(), login.getPassword());
				loginStatus.setStatus(true);
				loginStatus.setName(bidder.getFullName());
				loginStatus.setId(bidder.getId());
				loginStatus.setStatusMessage("Login Successful!");
				return loginStatus;
			}
			catch(BidderServiceException e2) {
				loginStatus.setStatus(false);
				loginStatus.setStatusMessage("User not found!");
						
			}
		
			
		}
		
		return loginStatus;
		
		
	}
	

}
