package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Bidder;
import com.lti.exception.BidderServiceException;
import com.lti.repository.BidderDao;

@Service
public class BidderService {
	
	@Autowired
	private BidderDao bDao;
	
	@Autowired
	private EmailService emailService;
	
	public void register(Bidder bidder) {
		if(bDao.fetchById(Bidder.class, bidder.getId())==null) {
			bDao.save(bidder);
			//emailService.sendMailForNewBidderRegisteration(bidder);

		}	
	    else 
		    throw new BidderServiceException("Bidder already registered!");	
	}
	
	public Bidder login(String email, String password) {
		try {
			int id = bDao.findByEmailAndPassword(email, password);
		    return bDao.fetchById(Bidder.class, id);	
		}
		catch(EmptyResultDataAccessException e) {
			throw new BidderServiceException("Invalid email/password");
		}
	}

}
