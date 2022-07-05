package com.exploremore.service;

import java.util.List;

import com.exploremore.exceptions.GlobalException;

import com.exploremore.pojo.PaymentPojo;



public interface PaymentService {
	PaymentPojo addPaymentInfo(PaymentPojo paymentPojo) throws GlobalException;
	
	
	public List<PaymentPojo> getPaymentInfo(int userId) throws GlobalException;
}
