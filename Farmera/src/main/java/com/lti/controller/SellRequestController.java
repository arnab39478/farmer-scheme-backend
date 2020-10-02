package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CropDetails;
import com.lti.dto.Status;
import com.lti.exception.SellRequestServiceException;
import com.lti.service.SellRequestService;

@RestController
@CrossOrigin
public class SellRequestController {
	
	@Autowired
	private SellRequestService sellRequestService;
	
	@PostMapping(value = "/place-sell-request")
	public Status placeSellRequest(@RequestBody CropDetails cropDetails) {
		try {
			sellRequestService.register(cropDetails);
			Status status = new Status();
			status.setStatus(true);
			status.setStatusMessage("Sell Request Placed!");
		    return status;
		}
		catch (SellRequestServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
		
	}

}
