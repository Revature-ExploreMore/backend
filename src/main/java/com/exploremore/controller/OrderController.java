package com.exploremore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.exceptions.EmptyOrderList;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.exceptions.OrderNotFoundException;
import com.exploremore.pojo.OrderCoursePojo;
import com.exploremore.pojo.OrderCourseSet;
import com.exploremore.pojo.OrderPojo;
import com.exploremore.service.OrderService;

@CrossOrigin(origins="*") // to enable cors
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService orderService;


	@PostMapping("addorders")
	public OrderPojo addOrder(@RequestBody OrderPojo orderPojo) throws GlobalException{ 
		return orderService.addOrder(orderPojo);
	}
	
	@PostMapping("orders")
	public Integer addCoursesToNewOrder(@RequestBody OrderCourseSet orderCourseSet) throws GlobalException {
		return orderService.addCoursesToOrder(orderCourseSet);
	}
	
	@GetMapping("{oID}")
	public List<OrderPojo> viewOrderById(@PathVariable("oID") int orderId) throws GlobalException, OrderNotFoundException { 
		return orderService.viewOrderById(orderId);
	}

	@GetMapping("allorders")
	public List<OrderPojo> viewAllOrders() throws GlobalException, EmptyOrderList {
		List<OrderPojo> allOrders = orderService.viewAllOrders();
		return allOrders;
	}
	
	@GetMapping("orderCourse/{id}")
	public List<OrderCoursePojo> getCoursesOrdersByUserId(@PathVariable("id") int userId) {
		return orderService.getUserOrders(userId);
	}


}
