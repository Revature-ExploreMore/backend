package com.exploremore.service;

import java.util.List;

import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;
import com.exploremore.pojo.UserPojo;

public interface CartService {
	
	List<CartCoursePojo> getCartCourses(int cart_id);
	
	CartPojo getCart(int user_id);
	
	boolean deleteCartCourse(int cart_course_id);
	
	CartPojo addNewCartToUser(UserPojo user);
	
	int addCourseToCart(CartCoursePojo cartCourse);

}
