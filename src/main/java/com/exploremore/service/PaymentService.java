package com.exploremore.service;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.PaymentPojo;

public interface PaymentService {
	PaymentPojo addPaymentInfo(PaymentPojo paymentPojo) throws GlobalException;
	PaymentPojo getPaymentInfo(int userId) throws GlobalException;
}
