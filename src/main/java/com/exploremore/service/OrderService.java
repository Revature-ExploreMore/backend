package com.exploremore.service;

import java.util.List;

import com.exploremore.pojo.OrderPojo;

public interface OrderService {
	
List<OrderPojo> viewAllOrders();
List<OrderPojo> viewOrderById (int id);
	OrderPojo addOrder(OrderPojo orderPojo);
}
