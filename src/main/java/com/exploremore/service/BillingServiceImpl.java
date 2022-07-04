package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List <BillingPojo> getBillingAddress(int userId) throws GlobalException {
		List <BillingEntity> billingEntity = billingDao.findByUserIdEquals(userId);
		List <BillingPojo> allBillingPojo = new ArrayList<>();
	
		for(BillingEntity eachEntity : billingEntity ) {
			
			BillingPojo billingPojo = new BillingPojo();
			BeanUtils.copyProperties(eachEntity,billingPojo);
			allBillingPojo.add(billingPojo);
		}
		return allBillingPojo;
	} 
	
}
