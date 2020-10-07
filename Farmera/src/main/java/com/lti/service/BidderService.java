package com.lti.service;

import com.lti.entity.Bidder;

public interface BidderService {

	int checkForBidder(String email);

	int checkIfPresent(String email, String password);

	void register(Bidder bidder);

	Bidder login(String email, String password);

}