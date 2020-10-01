package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Bidder;
import com.lti.exception.BidderServiceException;
import com.lti.service.BidderService;


@RestController
@CrossOrigin
public class BidderController {
	
	@Autowired
	private BidderService bidderService;	
	
	@PostMapping(path = "/bidder-register")
	public Status register(@RequestBody Bidder bidder) {
		try {
			bidderService.register(bidder);
			Status status = new Status();
			status.setStatus(true);
			status.setStatusMessage("Bidder Registration Successful!");
		    return status;
		}
		catch (BidderServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}

}
