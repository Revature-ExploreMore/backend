package com.exploremore.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.PaymentDao;import com.exploremore.entity.PaymentEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.PaymentPojo;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentDao paymentDao;

	@Override
	public PaymentPojo addPaymentInfo(PaymentPojo paymentPojo) throws GlobalException{
		PaymentEntity paymentEntity = new PaymentEntity();
		
		BeanUtils.copyProperties(paymentPojo, paymentEntity);
		
		PaymentEntity returnedPaymentEntity = paymentDao.saveAndFlush(paymentEntity);
		paymentPojo.setId(returnedPaymentEntity.getId());
		return paymentPojo;
	}

	@Override
	public PaymentPojo getPaymentInfo(int userId) throws GlobalException{
		Optional<PaymentEntity> paymentEntity = paymentDao.findByUserId(userId);
		PaymentPojo paymentPojo = null;
		
		if (paymentEntity.isPresent()) {
			PaymentEntity fetchedPaymentEntity = paymentEntity.get();
			paymentPojo = new PaymentPojo();
			BeanUtils.copyProperties(fetchedPaymentEntity, paymentPojo);
		}
		
		return paymentPojo;
		
	}
	
	

}
