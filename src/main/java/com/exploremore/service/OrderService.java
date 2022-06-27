package com.exploremore.service;

import java.util.List;

import com.exploremore.pojo.OrderPojo;

public interface OrderService {

	List<OrderPojo> viewOrderById(int orderId);

	List<OrderPojo> viewAllOrders();

}
