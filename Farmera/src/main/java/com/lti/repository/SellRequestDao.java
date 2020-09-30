package com.lti.repository;

import java.util.List;

import com.lti.entity.SellRequest;

public interface SellRequestDao {

	List<SellRequest> fetchSellRequestsByFarmer(String email);

	List<SellRequest> fetchSellRequestsBidByBidder(String email);

}