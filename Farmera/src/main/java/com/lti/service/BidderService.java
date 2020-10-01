package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Bidder;
import com.lti.exception.FarmerServiceException;
import com.lti.repository.GenericDaoImpl;

@Service
public class BidderService {
	
	@Autowired
	private GenericDaoImpl dao;
	
	@Autowired
	private EmailService emailService;
	
	public void register(Bidder bidder) {
		if(dao.fetchById(Bidder.class, bidder.getEmailId())==null) {
			dao.save(bidder);
			emailService.sendMailForNewBidderRegisteration(bidder);

		}	
	    else 
		    throw new FarmerServiceException("Bidder already registered!");	
	}

}
