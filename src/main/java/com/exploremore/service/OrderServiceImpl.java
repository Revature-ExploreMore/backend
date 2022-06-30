package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.OrderCourseDao;
import com.exploremore.dao.OrderDao;
import com.exploremore.entity.CourseEntity;
import com.exploremore.entity.OrderCourseEntity;
import com.exploremore.entity.OrderEntity;
import com.exploremore.entity.UserEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.pojo.CoursePojo;
import com.exploremore.pojo.OrderCoursePojo;
import com.exploremore.pojo.OrderPojo;
import com.exploremore.pojo.UserPojo;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderCourseDao orderCourseDao;
	
	

	@Override
	public OrderPojo addOrder(OrderPojo orderPojo) throws GlobalException{
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(orderPojo, orderEntity);
		
		UserEntity userEnt = new UserEntity();
		BeanUtils.copyProperties(orderPojo.getUser(), userEnt);
		orderEntity.setUser(userEnt);
		
		
		OrderEntity returnedOrderEntity = orderDao.saveAndFlush(orderEntity);
		orderPojo.setId(returnedOrderEntity.getId());
		return orderPojo;
	}



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
//		List<OrderEntity> searchOrderEntity = orderDao.findByOrderId(id);
//		List<OrderPojo> searchOrderPojo = new ArrayList<OrderPojo>();
//		
//		if(searchOrderEntity.isEmpty()) {
//			//throw exception
//		}
//		else {
//			for(OrderEntity fetchedOrderEntity : searchOrderEntity ) {
//				OrderPojo returnOrderPojo = new OrderPojo(fetchedOrderEntity.getId(), fetchedOrderEntity.getOrderTimestamp(), fetchedOrderEntity.getOrderTotal(), fetchedOrderEntity.getUserId());
//				
//				searchOrderPojo.add(returnOrderPojo);
//			}
//		}
//		return searchOrderPojo;
		return null;
	}



	@Override
	public List<OrderCoursePojo> getUserOrders(int userId) {
		System.out.println("hello");
		List<OrderCourseEntity> ordCourEnts = new ArrayList<>();
		ordCourEnts = orderCourseDao.findOrderCourseByUser(userId);
		
		List<OrderCoursePojo> ordCourPojos = new ArrayList<>();
		for (OrderCourseEntity ordCourEnt : ordCourEnts) {
			OrderCoursePojo ordCourPojo = new OrderCoursePojo();
			BeanUtils.copyProperties(ordCourEnt, ordCourPojo);
			CoursePojo coursePojo = new CoursePojo();
			BeanUtils.copyProperties(ordCourEnt.getCourse(), coursePojo);
			ordCourPojo.setCourse(coursePojo);
			OrderPojo orderPojo = new OrderPojo();
			BeanUtils.copyProperties(ordCourEnt.getOrder(), orderPojo);
			UserPojo userPojo = new UserPojo();
			BeanUtils.copyProperties(ordCourEnt.getOrder().getUser(), userPojo);
			orderPojo.setUser(userPojo);
			ordCourPojo.setOrder(orderPojo);
			CategoryPojo catPojo = new CategoryPojo();
			BeanUtils.copyProperties(ordCourEnt.getCourse().getCategory(), catPojo);
			ordCourPojo.getCourse().setCategoryId(catPojo);
			
			ordCourPojos.add(ordCourPojo);
		
		}
		
		return ordCourPojos;
	}

	


}
