<<<<<<< HEAD
//package com.exploremore.controller;
//
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.exploremore.entity.OrderEntity;
//import com.exploremore.pojo.OrderPojo;
//import com.exploremore.service.OrderService;
//
//@CrossOrigin
//@RestController
//@RequestMapping("order")
//public class OrderController {
//
//	@Autowired
//	OrderService orderService;
//
//	@GetMapping("orders/{oID}")
//	public OrderPojo addOrder(@PathVariable("oID") int orderId) { 
//	return orderService.addOrder(orderId);
//	}
//	
//	@GetMapping("orders/{oID}")
//	public List<OrderEntity> viewOrderById(@PathVariable("oID") int orderId) { 
//		return orderService.viewOrderById(orderId);
//	}
//
//	@GetMapping("orders")
//	public List<OrderPojo> viewAllOrders() {
//		List<OrderPojo> allOrders = orderService.viewAllOrders();
//		return allOrders;
//	}
//	
=======
package com.exploremore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.entity.OrderEntity;
import com.exploremore.pojo.OrderPojo;
import com.exploremore.service.OrderService;

@CrossOrigin(origins="*") // to enable cors
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService orderService;

//	@GetMapping("orders/{oID}")
//	public OrderPojo addOrder(@PathVariable("oID") int orderId) { 
//		return orderService.addOrder(orderId);
//	}
	
	@GetMapping("orders/{oID}")
	public List<OrderPojo> viewOrderById(@PathVariable("oID") int orderId) { 
		return orderService.viewOrderById(orderId);
	}

	@GetMapping("orders")
	public List<OrderPojo> viewAllOrders() {
		List<OrderPojo> allOrders = orderService.viewAllOrders();
		return allOrders;
	}
	
>>>>>>> development
//	@PutMapping("orders/{oID}")
//	public OrderPojo updateOrder(@RequestBody OrderPojo orderPojo) { 
//		return orderService.updateOrder(orderPojo);
//	}
<<<<<<< HEAD
//	
=======
	
>>>>>>> development
//	@DeleteMapping("orders/{oID}") 
//	public void deleteOrder(@PathVariable("oID") int orderId) {
//		return orderService.deleteOrder(orderId);
//	}
<<<<<<< HEAD
//}
=======
}
>>>>>>> development
