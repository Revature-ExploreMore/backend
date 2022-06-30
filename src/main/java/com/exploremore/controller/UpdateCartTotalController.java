package com.exploremore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.pojo.CartPojo;
import com.exploremore.service.UpdateCartTotalService;

@CrossOrigin
@RestController
@RequestMapping("update/cart")
public class UpdateCartTotalController {
	
	@Autowired
	UpdateCartTotalService updateCartTotalService;

	@PutMapping("books")
	public CartPojo updateCartTotal(@RequestBody CartPojo cartPojo) {
		return updateCartTotalService.updateCartTotal(cartPojo);
	}
}
