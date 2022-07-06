package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.PaymentDao;
import com.exploremore.entity.PaymentEntity;
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
	public List<PaymentPojo> getPaymentInfo(int userId) throws GlobalException{
		List<PaymentEntity> allPaymentEntity = paymentDao.findByUserId(userId);
		List<PaymentPojo> allCurrentUserPayInfo = new ArrayList<>();
		PaymentPojo paymentPojo = null;
		
		if(allPaymentEntity.isEmpty()) {
			throw new GlobalException("No Payment Info");
		}
		
		for(PaymentEntity paymentEntity : allPaymentEntity) {
			paymentPojo = new PaymentPojo(paymentEntity.getId(),paymentEntity.getCardType(),paymentEntity.getCardNumber(),paymentEntity.getExpDate(),paymentEntity.getCvv(),paymentEntity.getUserId());
			
			allCurrentUserPayInfo.add(paymentPojo);
		}
		
		return allCurrentUserPayInfo;
		
	}
	
	

}
