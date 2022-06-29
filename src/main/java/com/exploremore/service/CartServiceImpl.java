package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.CartCourseDao;
import com.exploremore.dao.CartDao;
import com.exploremore.entity.CartCourseEntity;
import com.exploremore.entity.CartEntity;
import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.pojo.CoursePojo;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartCourseDao cartCourseDao;
	

	@Override
	public List<CartCoursePojo> getCartCourses(int cart_id) {
		
		List<CartCourseEntity> allCartCourseEntity = cartCourseDao.findByCartId(cart_id);

		List<CartCoursePojo> allCartCoursePojo = new ArrayList<CartCoursePojo>();
		
		for(CartCourseEntity fetchedCartCourseEntity : allCartCourseEntity) {
			CartCoursePojo returnedCartCoursePojo = new CartCoursePojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity, returnedCartCoursePojo);
			
			//CartPojo fetchedCartPojo = new CartPojo();
			//BeanUtils.copyProperties(fetchedCartCourseEntity.getCart(), fetchedCartPojo);
			
			CoursePojo fetchedCoursePojo = new CoursePojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity.getCourse(), fetchedCoursePojo);
			
			CategoryPojo fetchedCategoryPojo = new CategoryPojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity.getCourse().getCategory(), fetchedCategoryPojo);
			
			//returnedCartCoursePojo.setCart(fetchedCartPojo);
			returnedCartCoursePojo.setCourse(fetchedCoursePojo);
			returnedCartCoursePojo.getCourse().setCategoryId(fetchedCategoryPojo);
			allCartCoursePojo.add(returnedCartCoursePojo);
		}
		return allCartCoursePojo;
	}

	@Override
	public CartPojo getCart(int user_id) {
		
		CartEntity currentCartEntity = cartDao.findByUserId(user_id);
		CartPojo currentCartPojo = new CartPojo();
		BeanUtils.copyProperties(currentCartEntity, currentCartPojo);
		
		return currentCartPojo;
	}

	@Override
	public boolean deleteCartCourse(int cart_course_id) {
		cartCourseDao.deleteById(cart_course_id);
		return true;
	};
}


