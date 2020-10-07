package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.CropDetails;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;
import com.lti.exception.SellRequestServiceException;
import com.lti.repository.FarmerRepo;
import com.lti.repository.SellRequestRepo;

@Service
public class SellRequestServiceImpl implements SellRequestService {
	
	@Autowired
	private FarmerRepo fRepo;
	
	@Autowired
	private SellRequestRepo srRepo;
	
	@Override
	public void register(CropDetails cropDetails) {

		Farmer farmer=fRepo.fetchById(Farmer.class, cropDetails.getFarmerId());
		if(farmer.getApprovedStatus()=='N')
			throw new SellRequestServiceException("Farmer not approved!");
		if(cropDetails.getSellingDeadline().compareTo(LocalDate.now())<0)
			throw new SellRequestServiceException("Enter proper selling deadline!");
		SellRequest sellRequest=new SellRequest();
		sellRequest.setCropType(cropDetails.getCropType());
		sellRequest.setCropName(cropDetails.getCropName());
		sellRequest.setQuantity(cropDetails.getQuantity());
		sellRequest.setBasePrice(cropDetails.getBasePrice());
		sellRequest.setRequestDate(LocalDate.now());
		sellRequest.setSellingDeadline(cropDetails.getSellingDeadline());
		sellRequest.setFertilizerType(cropDetails.getFertilizerType());
		sellRequest.setFarmer(farmer);
		sellRequest.setApprovedStatus('N');
		sellRequest.setBiddingStatus('O');
		srRepo.save(sellRequest);
	}

}
