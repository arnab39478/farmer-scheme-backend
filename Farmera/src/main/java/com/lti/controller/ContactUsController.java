package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Contact;
import com.lti.dto.Status;
import com.lti.service.EmailService;
import com.lti.service.FarmerService;

@RestController
@CrossOrigin
public class ContactUsController {
	
	@Autowired
	private EmailService emailService;
      
	@PostMapping(path = "/contact-us")
	public Status contactUs(@RequestBody Contact contact) {
		Status status = new Status();
		status.setStatus(true);
		emailService.sendMailToContactUs(contact.getEmail());
		status.setStatusMessage("Response Recorded!");
	    return status;
	}
}
