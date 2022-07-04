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

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.BillingPojo;
import com.exploremore.service.BillingService;

@CrossOrigin
@RestController
@RequestMapping("billing")
public class BillingController {
	
	@Autowired
	BillingService billingService;
	
	@PostMapping("billing-address")
	public BillingPojo addBillingAddress(@RequestBody BillingPojo billingPojo) throws GlobalException{
		
		return billingService.addBillingAddress(billingPojo);
		
	}
	
	@GetMapping("billing-address/{uid}")
	public List <BillingPojo> getBillingPojo(@PathVariable("uid")int userId) throws GlobalException {
		
		return billingService.getBillingAddress(userId);
	}
	
}
