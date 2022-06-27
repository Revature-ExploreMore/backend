package com.exploremore.service;

import com.exploremore.pojo.PaymentPojo;

public interface PaymentService {
	PaymentPojo addPaymentInfo(PaymentPojo paymentPojo);
	PaymentPojo getPaymentInfo(int userId);
}
