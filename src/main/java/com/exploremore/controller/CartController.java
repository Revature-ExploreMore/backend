package com.exploremore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;
import com.exploremore.pojo.UserPojo;
import com.exploremore.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("cartCourse/{cid}")
	public List<CartCoursePojo> getCartCoursesByCart(@PathVariable("cid") int cart_id) {
		//try {
			return cartService.getCartCourses(cart_id);
		//} catch (GlobalException e) {
			// TODO Auto-generated catch block						** please do not merge when errors are present
			//e.printStackTrace();										//recommend to use built-in exception until 
			//return null;                                              //  the global exception is configured; make a comment 
		//}                                                             //  of the necessary global exception
	}
	
	@GetMapping("cart/{uid}")
	public CartPojo getCartByUser(@PathVariable("uid") int user_id) throws GlobalException{
		return cartService.getCart(user_id);
	}
	
	@DeleteMapping("cartCourse/{ccid}")
	public boolean deleteCartCourse(@PathVariable("ccid") int cart_course_id) {
		return cartService.deleteCartCourse(cart_course_id);
	}
	
	@PostMapping("cart")
	public CartPojo addCartToUser(@RequestBody UserPojo user) {
		return cartService.addNewCartToUser(user.getId());
	}
	
	@PostMapping("cartCourse")
    public int addCourseToCart(@RequestBody CartCoursePojo cartCourse) {
        System.out.println("hello");
        return cartService.addCourseToCart(cartCourse);
    }
	
	@DeleteMapping("/{cid}")
	public boolean emptyCart(@PathVariable("cid") int cartId) throws GlobalException{
		return cartService.emptyCart(cartId);
	}
}
