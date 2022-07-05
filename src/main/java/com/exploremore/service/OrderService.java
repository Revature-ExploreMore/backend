package com.exploremore.service;

import java.util.List;

import com.exploremore.exceptions.EmptyOrderList;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.exceptions.OrderNotFoundException;
import com.exploremore.pojo.OrderCoursePojo;
import com.exploremore.pojo.OrderCourseSet;
import com.exploremore.pojo.OrderPojo;

public interface OrderService {

	
	List<OrderPojo> viewAllOrders() throws GlobalException, EmptyOrderList;
	List<OrderPojo> viewOrderById (int id) throws GlobalException, OrderNotFoundException;
	OrderPojo addOrder(OrderPojo orderPojo) throws GlobalException;
	List<OrderCoursePojo> getUserOrders(int userId);
	Integer addCoursesToOrder(OrderCourseSet orderCourseSet) throws GlobalException;
}
