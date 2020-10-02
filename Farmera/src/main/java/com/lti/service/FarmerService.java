package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.lti.entity.Farmer;
import com.lti.exception.FarmerServiceException;
import com.lti.repository.FarmerDao;

@CrossOrigin
@Service
public class FarmerService {
	
	@Autowired
	private FarmerDao fDao;
	
	@Autowired
	private EmailService emailService;
	
	public void register(Farmer farmer) {
		if(fDao.fetchById(Farmer.class, farmer.getId())==null) {
			fDao.save(farmer);
			//emailService.sendMailForNewFarmerRegisteration(farmer);
		}	
	    else 
		    throw new FarmerServiceException("Farmer already registered!");	
	}
	
	public Farmer login(String email, String password) {
		try {
			int id = fDao.findByEmailAndPassword(email, password);
		    return fDao.fetchById(Farmer.class, id);	
		}
		catch(EmptyResultDataAccessException e) {
			throw new FarmerServiceException("Invalid email/password");
		}
	}


}
