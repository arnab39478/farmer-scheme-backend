package com.lti.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CropForSale;
import com.lti.dto.CropList;
import com.lti.dto.SoldCrop;
import com.lti.dto.SoldCropList;
import com.lti.dto.Status;
import com.lti.entity.Farmer;
import com.lti.exception.FarmerServiceException;
import com.lti.service.FarmerService;

@RestController
@CrossOrigin
public class FarmerController {
	
	@Autowired
	private FarmerService farmerService;
	
	@Value("${upload.dir}")
	private String uploadLocation;
	
	@PostMapping(path = "/farmer-register")
	public Status register(@RequestBody Farmer farmer) {
		try {
			farmerService.register(farmer);
			Status status = new Status();
			status.setStatus(true);
			status.setStatusMessage("Farmer Registration Successful!");
		    return status;
		}
		catch (FarmerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
	@GetMapping(path = "/sold-crop-history")
	public SoldCropList viewSoldCropHistory(@RequestParam("farmerId") int farmerId) {
		
		List<SoldCrop> list=farmerService.getSoldCrops(farmerId);
		SoldCropList listOfCrops=new SoldCropList();
		listOfCrops.setStatus(true);
		listOfCrops.setStatusMessage("Bidding in Process!");
		listOfCrops.setSoldCrop(list);
		return listOfCrops;
	}
	

}
