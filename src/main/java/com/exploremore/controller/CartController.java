//package com.exploremore.controller;
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.exploremore.exceptions.GlobalException;
//import com.exploremore.pojo.CartCoursePojo;
//import com.exploremore.service.CartService;
//
////@CrossOrigin
////@RestController
////@RequestMapping("cart")
////public class CartController {
////	
////	@Autowired
////	CartService cartService;
////	
////	@GetMapping("/cartcourse/{cart_id}")
////	public List<CartCoursePojo> getCartCoursesByCart(@PathVariable("cart_id") int id) {
////		try {
////			return cartService.getCartCourses(id);
////		} catch (GlobalException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////			return null;
////		}
////	}
////	
////}
