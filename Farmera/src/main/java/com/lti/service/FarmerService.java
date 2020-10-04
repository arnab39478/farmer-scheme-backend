package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.lti.dto.CropForSale;
import com.lti.entity.Bidder;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;
import com.lti.exception.FarmerServiceException;
import com.lti.repository.FarmerDao;
import com.lti.repository.SellRequestDao;

@Service
public class FarmerService {
	
	@Autowired
	private FarmerDao fDao;
	
	@Autowired
	private SellRequestDao srDao;
	
	@Autowired
	private EmailService emailService;
	
	public int checkForFarmer(String email) {
		if(fDao.isFarmerRegistered(email)) 
			return 1;
		else return 0;	
	}
	
	public int checkIfPresent(String email, String password) {
		if(fDao.isFarmerPresent(email,password)) 
			return 1;
		else return 0;	
	}
	
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
	
	public List<CropForSale> getCrops(int farmerId){
		
		List<CropForSale> crops=new ArrayList<>();
		List<SellRequest> sellRequests=srDao.fetchSellRequestsByFarmer(farmerId);
		for(SellRequest sr: sellRequests)
		{
			CropForSale crop=new CropForSale();
			crop.setCropId(sr.getRequestId());
			crop.setCropType(sr.getCropType());
			crop.setCropName(sr.getCropName());
			crop.setBasePrice(sr.getBasePrice());
			crops.add(crop);
		}
		return crops;
		
	}


}
