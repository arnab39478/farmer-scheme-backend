package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Farmer;
import com.lti.exception.FarmerServiceException;
import com.lti.repository.GenericDaoImpl;


@Service
public class FarmerService {
	
	@Autowired
	private GenericDaoImpl dao;
	
	@Autowired
	private EmailService emailService;
	
	public void register(Farmer farmer) {
		if(dao.fetchById(Farmer.class, farmer.getEmailId())==null) {
			dao.save(farmer);
			emailService.sendMailForNewFarmerRegisteration(farmer);
			//then code to send an email to the farmer will be here
		}	
	    else 
		    throw new FarmerServiceException("Farmer already registered!");	
	}


}
