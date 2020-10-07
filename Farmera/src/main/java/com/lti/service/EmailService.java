package com.lti.service;

import com.lti.entity.Bidder;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;

public interface EmailService {

	void sendMailForNewFarmerRegisteration(Farmer farmer);

	void sendMailForNewBidderRegisteration(Bidder bidder);

	void sendMailForCropSellRequest(SellRequest request);

	void sendResetLink(String email);

	void sendMailToContactUs(String email);

	void sendMailForSoldCrop(Farmer farmer);

	void sendMailForWinningBid(Bidder bidder);

}