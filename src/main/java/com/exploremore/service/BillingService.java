package com.exploremore.service;

import java.util.List;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.BillingPojo;

public interface BillingService {
	BillingPojo addBillingAddress(BillingPojo billingPojo) throws GlobalException;
	
	List <BillingPojo> getBillingAddress(int userId)throws GlobalException;
}
