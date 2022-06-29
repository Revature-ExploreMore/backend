package com.exploremore.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.exploremore.dao.UpdateCartTotalDao;
import com.exploremore.entity.CartEntity;
import com.exploremore.pojo.CartPojo;

public class UpdateCartTotalServiceImpl implements UpdateCartTotalService {
	
	@Autowired
	UpdateCartTotalDao updateCartTotalDao;

	@Override
	public CartPojo updateCartTotal(CartPojo cartPojo) {
		CartEntity cartEntity = new CartEntity();
		BeanUtils.copyProperties(cartPojo, cartEntity);
		
		updateCartTotalDao.save(cartEntity);
		
		return cartPojo;
	}

}
