package com.exploremore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.pojo.OrderPojo;
import com.exploremore.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
//	@GetMapping("orders")
//	public List<OrderPojo> getAllOrders() {
//		List<OrderPojo> allOrders = new orderService.getAllOrders();
//		return allOrders;
//	}
	
}