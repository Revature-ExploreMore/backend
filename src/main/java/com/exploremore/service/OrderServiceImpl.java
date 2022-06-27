package com.exploremore.service;

<<<<<<< HEAD
<<<<<<< HEAD
public class OrderServiceImpl implements OrderService {
=======
=======

>>>>>>> a6250c0c8632db463f6abbdf2b15456161e8ed5f
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.exploremore.dao.OrderDao;
import com.exploremore.entity.OrderEntity;
import com.exploremore.pojo.OrderPojo;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;

	@Override
	public List<OrderPojo> viewAllOrders() {
		List<OrderEntity> allOrderEntity = orderDao.findAll();
		List<OrderPojo> allOrderPojo = new ArrayList<OrderPojo>();
		
		if(allOrderEntity.isEmpty()) {
			//throw Exception
		}
		else {
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
			//throw exception
		}
		else {
			for(OrderEntity fetchedOrderEntity : searchOrderEntity ) {
				OrderPojo returnOrderPojo = new OrderPojo(fetchedOrderEntity.getId(), fetchedOrderEntity.getOrderTimestamp(), fetchedOrderEntity.getOrderTotal(), fetchedOrderEntity.getUserId());
				
				searchOrderPojo.add(returnOrderPojo);
			}
		}
		return searchOrderPojo;
	}
<<<<<<< HEAD
>>>>>>> Akshay
=======

>>>>>>> a6250c0c8632db463f6abbdf2b15456161e8ed5f

}
