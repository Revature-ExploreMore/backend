package com.exploremore.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.CartCourseDao;
import com.exploremore.dao.CartDao;
import com.exploremore.entity.CartCourseEntity;
import com.exploremore.entity.CartEntity;
import com.exploremore.entity.CategoryEntity;
import com.exploremore.entity.CourseEntity;
import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;
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
			CartPojo fetchedCartPojo = new CartPojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity.getCart(), fetchedCartPojo);
			CoursePojo fetchedCoursePojo = new CoursePojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity.getCourse(), fetchedCoursePojo);
			returnedCartCoursePojo.setCart(fetchedCartPojo);
			returnedCartCoursePojo.setCourse(fetchedCoursePojo);
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
	
	@Override
	public CartPojo addNewCartToUser(int user_id) {
		CartEntity cart = new CartEntity(0, LocalDateTime.now(), LocalDateTime.now(), false, 
				BigDecimal.valueOf(0), user_id);
		cart.setOrderId(1);
		cart = cartDao.save(cart);
		CartPojo cartPojo = new CartPojo();
		BeanUtils.copyProperties(cart, cartPojo);
		return cartPojo;
	}

	@Override
	public int addCourseToCart(CartCoursePojo cartCourse) {
		System.out.println(cartCourse);
		CoursePojo coursePojo = cartCourse.getCourse();
		CartPojo cartPojo = cartCourse.getCart();
		
		return cartCourseDao.saveByCourseIdAndCartId(coursePojo.getId(), cartPojo.getId());
		
//		CategoryEntity catEntity = new CategoryEntity();
//		BeanUtils.copyProperties(coursePojo.getCategory(), catEntity);
//		CourseEntity courseEntity = new CourseEntity(
//				coursePojo.getId(), coursePojo.getName(), coursePojo.getDescription(),
//				coursePojo.getPrice(), coursePojo.getImageUrl(), catEntity);
//		
////		BeanUtils.copyProperties(cartCourse.getCourse(), courseEntity);
//		System.out.println("courEntity " + courseEntity);
//		CartEntity cartEntity = new CartEntity(
//				cartPojo.getId(), cartPojo.getCreatedAt(), cartPojo.getModifiedAt(),
//				cartPojo.isRemoved(), cartPojo.getCartTotal(), cartPojo.getUserId(), cartPojo.getOrderId());
////		BeanUtils.copyProperties(cartCourse.getCart(), cartEntity);
//		
//		System.out.println("cartEntity " + cartEntity);
//		CartCourseEntity cartCourseEntity = new CartCourseEntity();
//		cartCourseEntity.setCourse(courseEntity);
//		cartCourseEntity.setCart(cartEntity);
//		System.out.println("cartCourseEntity " + cartCourseEntity);
//		cartCourseEntity = cartCourseDao.save(cartCourseEntity);
//		CartCoursePojo cartCoursePojo = new CartCoursePojo();
//		BeanUtils.copyProperties(cartCourseEnt, cartCoursePojo);
//		return cartCoursePojo;
	}
}


