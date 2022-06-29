package com.exploremore.service;

import org.springframework.stereotype.Service;

import com.exploremore.pojo.CartPojo;

@Service
public interface UpdateCartTotalService {
	
	CartPojo updateCartTotal(CartPojo cartPojo);
	
	

}
