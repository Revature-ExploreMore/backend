package com.exploremore.service;

import java.util.List;

import com.exploremore.exceptions.EmptyCartException;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;
import com.exploremore.pojo.UserPojo;

public interface CartService {
	
	List<CartCoursePojo> getCartCourses(int cart_id) throws GlobalException, EmptyCartException;
	
	CartPojo getCart(int user_id) throws GlobalException;
	
	boolean deleteCartCourse(int cart_course_id) throws GlobalException;
	
	CartPojo addNewCartToUser(UserPojo user) throws GlobalException;
	
	int addCourseToCart(CartCoursePojo cartCourse) throws GlobalException;
	
	boolean emptyCart(int cartId) throws GlobalException;

}
