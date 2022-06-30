package com.exploremore.service;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.BillingPojo;

public interface BillingService {
	BillingPojo addBillingAddress(BillingPojo billingPojo) throws GlobalException;
}
