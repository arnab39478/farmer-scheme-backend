package com.lti.repository;

import java.util.List;

import com.lti.entity.SellRequest;

public interface SellRequestRepo extends GenericRepo {

	List<SellRequest> fetchSellRequestsByFarmer(int id);

	List<SellRequest> fetchSellRequestsBidByBidder(String email);

	List<SellRequest> fetchCropSellRequests();

}