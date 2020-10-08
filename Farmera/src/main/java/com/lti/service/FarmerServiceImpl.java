package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.dto.CropForSale;
import com.lti.dto.SoldCrop;
import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;
import com.lti.exception.FarmerServiceException;
import com.lti.repository.BiddingRequestRepo;
import com.lti.repository.FarmerRepo;
import com.lti.repository.SellRequestRepo;

@Service
public class FarmerServiceImpl implements FarmerService {
	
	@Autowired
	private FarmerRepo fRepo;
	
	@Autowired
	private SellRequestRepo srRepo;
	
	@Autowired
	private BiddingRequestRepo brRepo;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public int checkForFarmer(String email) {
		if(fRepo.isFarmerRegistered(email)) 
			return 1;
		else return 0;	
	}
	
	@Override
	public int checkIfPresent(String email, String password) {
		if(fRepo.isFarmerPresent(email,password)) 
			return 1;
		else return 0;	
	}
	
	@Override
	public void register(Farmer farmer) {
		if(fRepo.fetchById(Farmer.class, farmer.getId())==null) {
			fRepo.save(farmer);
			emailService.sendMailForNewFarmerRegisteration(farmer);
		}	
	    else 
		    throw new FarmerServiceException("Farmer already registered!");	
	}
	
	@Override
	public Farmer login(String email, String password) {
		try {
			int id = fRepo.findByEmailAndPassword(email, password);
		    return fRepo.fetchById(Farmer.class, id);	
		}
		catch(EmptyResultDataAccessException e) {
			throw new FarmerServiceException("Invalid email/password");
		}
	}
	
	@Override
	public List<CropForSale> getCrops(int farmerId){
		
		List<CropForSale> crops=new ArrayList<>();
		List<SellRequest> sellRequests=srRepo.fetchSellRequestsByFarmer(farmerId);
		for(SellRequest sr: sellRequests)
		{
			CropForSale crop=new CropForSale();
			crop.setCropId(sr.getRequestId());
			crop.setCropType(sr.getCropType());
			crop.setCropName(sr.getCropName());
			crop.setBasePrice(sr.getBasePrice());
			crop.setBiddingDeadline(sr.getBiddingDeadline());
			crops.add(crop);
		}
		return crops;
		
	}
	
	@Override
	public List<SoldCrop> getSoldCrops(int farmerId){
		
		List<SoldCrop> soldCrops=new ArrayList<>();
		List<BiddingRequest> biddingRequests=brRepo.getCropsSoldToBidder(farmerId);
		for(BiddingRequest br: biddingRequests)
		{
			SoldCrop crop=new SoldCrop();
			crop.setSellRequestId(br.getSellRequest().getRequestId());
			crop.setCropName(br.getSellRequest().getCropName());
			crop.setBasePrice(br.getSellRequest().getBasePrice());
			crop.setQuantity(br.getSellRequest().getQuantity());
			crop.setSoldPrice(br.getAmount());
			crop.setSoldDate(br.getSellRequest().getSellingDeadline());
			soldCrops.add(crop);
		}
		return soldCrops;
		
	}


}
