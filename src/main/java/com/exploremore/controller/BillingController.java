package com.exploremore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.pojo.BillingPojo;
import com.exploremore.service.BillingService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class BillingController {
	
	@Autowired
	BillingService billingService;
	
	@PostMapping("billing-address")
	public BillingPojo addBillingAddress(@RequestBody BillingPojo billingPojo) {
		
		return billingService.addBillingAddress(billingPojo);
		
	}
	
}
