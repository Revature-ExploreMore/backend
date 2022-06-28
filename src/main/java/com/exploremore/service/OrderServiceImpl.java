package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.OrderDao;
import com.exploremore.entity.OrderEntity;
import com.exploremore.pojo.OrderPojo;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	

	@Override
	public OrderPojo addOrder(OrderPojo orderPojo) {
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(orderPojo, orderEntity);
		OrderEntity returnedOrderEntity = orderDao.saveAndFlush(orderEntity);
		orderPojo.setId(returnedOrderEntity.getId());
		return orderPojo;
	}


@Override
public List<OrderPojo> viewAllOrders() {
List<OrderEntity> allOrderEntity = orderDao.findAll();
List<OrderPojo> allOrderPojo = new ArrayList<OrderPojo>();

if(allOrderEntity.isEmpty()) {
throw Exception
}
for(OrderEntity fetchedOrderEntity : allOrderEntity) {
OrderPojo returnedOrderPojo = new OrderPojo(fetchedOrderEntity.getId(), fetchedOrderEntity.getOrderTimestamp(), fetchedOrderEntity.getOrderTotal(), fetchedOrderEntity.getUserId());

allOrderPojo.add(returnedOrderPojo);
}
}
return allOrderPojo;
}

@Override
public List<OrderPojo> viewOrderById(int id) {
List<OrderEntity> searchOrderEntity = orderDao.findByOrderId(id);
List<OrderPojo> searchOrderPojo = new ArrayList<OrderPojo>();	
if(searchOrderEntity.isEmpty()) {
throw exception
}
else {
for(OrderEntity fetchedOrderEntity : searchOrderEntity ) {
OrderPojo returnOrderPojo = new OrderPojo(fetchedOrderEntity.getId(), fetchedOrderEntity.getOrderTimestamp(), fetchedOrderEntity.getOrderTotal(), fetchedOrderEntity.getUserId());

searchOrderPojo.add(returnOrderPojo);
}
}
return searchOrderPojo;
}


}
