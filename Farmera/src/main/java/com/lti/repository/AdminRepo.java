package com.lti.repository;

import java.util.List;

import javax.persistence.NoResultException;

import com.lti.entity.Admin;
import com.lti.entity.Bidder;
import com.lti.entity.BiddingRequest;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;

public interface AdminRepo extends GenericRepo{

	List<Farmer> getAllFarmers();

	List<Bidder> getAllBidders();

	List<SellRequest> getAllSellRequests();

	List<BiddingRequest> getAllBiddingRequests();

	BiddingRequest fetchWinningBid(int id);

	Admin fetchByEmailAndPassword(String email, String password) throws NoResultException;

}