package com.lti.service;

import java.util.List;

import com.lti.dto.CropForSale;
import com.lti.dto.SoldCrop;
import com.lti.entity.Farmer;

public interface FarmerService {

	int checkForFarmer(String email);

	int checkIfPresent(String email, String password);

	void register(Farmer farmer);

	Farmer login(String email, String password);

	List<CropForSale> getCrops(int farmerId);

	List<SoldCrop> getSoldCrops(int farmerId);

}