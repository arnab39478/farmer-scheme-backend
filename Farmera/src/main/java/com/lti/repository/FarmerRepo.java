package com.lti.repository;


public interface FarmerRepo extends GenericRepo {

	boolean isFarmerRegistered(String email);

	boolean isFarmerPresent(String email, String password);

	int findByEmailAndPassword(String email, String password);

}