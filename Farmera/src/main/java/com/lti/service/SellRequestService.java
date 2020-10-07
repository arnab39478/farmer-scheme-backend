package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.CropDetails;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;
import com.lti.exception.SellRequestServiceException;
import com.lti.repository.FarmerDao;
import com.lti.repository.SellRequestDao;

@Service
public class SellRequestService {
	
	@Autowired
	private FarmerDao fdao;
	
	@Autowired
	private SellRequestDao srDao;
	
	public void register(CropDetails cropDetails) {

		Farmer farmer=fdao.fetchById(Farmer.class, cropDetails.getFarmerId());
		if(farmer.getApprovedStatus()=='N')
			throw new SellRequestServiceException("Farmer not approved!");
		SellRequest sellRequest=new SellRequest();
		sellRequest.setCropType(cropDetails.getCropType());
		sellRequest.setCropName(cropDetails.getCropName());
		sellRequest.setQuantity(cropDetails.getQuantity());
		sellRequest.setBasePrice(cropDetails.getBasePrice());
		sellRequest.setRequestDate(LocalDate.now());
		sellRequest.setSellingDeadline(cropDetails.getSellingDeadline());
		sellRequest.setFertilizerType(cropDetails.getFertilizerType());
		sellRequest.setFarmer(farmer);
		sellRequest.setApprovedStatus('Y');

		srDao.save(sellRequest);
	}

}
