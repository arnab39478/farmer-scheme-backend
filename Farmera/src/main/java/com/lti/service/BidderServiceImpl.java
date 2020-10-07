package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Bidder;
import com.lti.exception.BidderServiceException;
import com.lti.repository.BidderRepo;

@Service
public class BidderServiceImpl implements BidderService {
	
	@Autowired
	private BidderRepo bRepo;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public int checkForBidder(String email) {
		if(bRepo.isBidderRegistered(email)) 
			return 1;
		else return 0;	
	}
	
	@Override
	public int checkIfPresent(String email, String password) {
		if(bRepo.isBidderPresent(email,password)) 
			return 1;
		else return 0;
		
	}
		
	@Override
	public void register(Bidder bidder) {
		if(bRepo.fetchById(Bidder.class, bidder.getId())==null) {
			bRepo.save(bidder);
			//emailService.sendMailForNewBidderRegisteration(bidder);

		}	
	    else 
		    throw new BidderServiceException("Bidder already registered!");	
	}
	
	@Override
	public Bidder login(String email, String password) {
		try {
			int id = bRepo.findByEmailAndPassword(email, password);
		    return bRepo.fetchById(Bidder.class, id);	
		}
		catch(EmptyResultDataAccessException e) {
			throw new BidderServiceException("Invalid email/password");
		}
	}

}
