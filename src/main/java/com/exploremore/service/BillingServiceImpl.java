package com.exploremore.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.BillingDao;
import com.exploremore.entity.BillingEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.BillingPojo;

@Service
public class BillingServiceImpl implements BillingService{
	
	@Autowired
	BillingDao billingDao;

	@Override
	public BillingPojo addBillingAddress(BillingPojo billingPojo) throws GlobalException{
		BillingEntity billingEntity = new BillingEntity();
		BeanUtils.copyProperties(billingPojo, billingEntity);
		
		BillingEntity returnedBillingEntity = billingDao.saveAndFlush(billingEntity);
		billingPojo.setId(returnedBillingEntity.getId());
		return billingPojo;
	}
	
}
