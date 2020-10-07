package com.lti.repository;

public interface BidderRepo extends GenericRepo{

	boolean isBidderRegistered(String email);

	boolean isBidderPresent(String email, String password);

	int findByEmailAndPassword(String email, String password);

}