package com.exploremore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	UserService userService;
	

}
