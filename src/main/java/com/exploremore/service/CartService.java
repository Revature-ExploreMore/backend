package com.exploremore.service;

import java.util.List;

import com.exploremore.pojo.CartCoursePojo;

public interface CartService {
	
	List<CartCoursePojo> getCartCourses(int user_id);

}
