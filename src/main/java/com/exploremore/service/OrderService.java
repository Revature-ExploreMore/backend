package com.exploremore.service;

import java.util.List;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.OrderCoursePojo;
import com.exploremore.pojo.OrderPojo;
import com.exploremore.pojo.UserPojo;

public interface OrderService {

	
	List<OrderPojo> viewAllOrders();
	List<OrderPojo> viewOrderById (int id);
	OrderPojo addOrder(OrderPojo orderPojo) throws GlobalException;
	List<OrderCoursePojo> getUserOrders(int userId);

}
