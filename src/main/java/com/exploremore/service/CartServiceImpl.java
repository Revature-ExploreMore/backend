package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.CartDao;
import com.exploremore.entity.CartCourseEntity;
import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;

	@Override
	public List<CartCoursePojo> getCartCourses(int cart_id) {
		
		List<CartCourseEntity> allCartCourseEntity = cartDao.findByCartId(cart_id);
		List<CartCoursePojo> allCartCoursePojo = new ArrayList<CartCoursePojo>();
		
		for(CartCourseEntity fetchedCartCourseEntity : allCartCourseEntity) {
			CartCoursePojo returnedCartCoursePojo = new CartCoursePojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity, returnedCartCoursePojo);
			CartPojo fetchedCartPojo = new CartPojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity.getCart(), fetchedCartPojo);
			returnedCartCoursePojo.setCart(fetchedCartPojo);
			allCartCoursePojo.add(returnedCartCoursePojo);
		}
		return allCartCoursePojo;
	};
}


