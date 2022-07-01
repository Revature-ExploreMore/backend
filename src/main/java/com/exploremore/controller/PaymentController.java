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
import com.exploremore.pojo.PaymentPojo;
import com.exploremore.service.PaymentService;



@CrossOrigin
@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("payment")
	public PaymentPojo addPaymentInfo(@RequestBody PaymentPojo paymentPojo) throws GlobalException{
		
		return paymentService.addPaymentInfo(paymentPojo);
		
	}
	
	@GetMapping("payment/{uid}")
	public List<PaymentPojo> getPaymentInfo(@PathVariable("uid") int userId) throws GlobalException{
		return paymentService.getPaymentInfo(userId);
	}
}
