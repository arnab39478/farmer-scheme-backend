package com.lti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Farmer;
import com.lti.exception.FarmerServiceException;
import com.lti.service.BidderService;
import com.lti.service.EmailService;
import com.lti.service.FarmerService;

@RestController
@CrossOrigin
public class ForgotPasswordController {
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private FarmerService farmerService;
	
	@Autowired
	private BidderService bidderService;
	
	@GetMapping("/forgot-password")
	public Status forgotPassword(@RequestParam("email") String email, HttpServletRequest request) {
			int farmerPresent = farmerService.checkForFarmer(email);
			int bidderPresent = bidderService.checkForBidder(email);
			
			Status status= new Status();
			if(farmerPresent==1) {
					status.setStatus(true);
					emailService.sendResetLink(email);
					status.setStatusMessage("Reset link sent! Please check your email.");
					return status;
			}
			else if(bidderPresent==1) {
				status.setStatus(true);
				emailService.sendResetLink(email);
				status.setStatusMessage("Reset link sent! Please check your email.");
				return status;
			}
			
			status.setStatus(false);
			status.setStatusMessage("No user found with emailid="+ email);
			return status;
	}

}
