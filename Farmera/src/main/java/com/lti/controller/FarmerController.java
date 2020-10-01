package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Farmer;
import com.lti.exception.FarmerServiceException;
import com.lti.service.FarmerService;

@RestController
public class FarmerController {
	
	@Autowired
	private FarmerService farmerService;
	
	
	@PostMapping(path = "/farmer-register")
	public Status register(@RequestBody Farmer farmer) {
		try {
			farmerService.register(farmer);
			Status status = new Status();
			status.setStatus(true);
			status.setStatusMessage("Farmer Registration Successful!");
		    return status;
		}
		catch (FarmerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	

}
