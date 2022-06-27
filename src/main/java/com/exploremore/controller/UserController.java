package com.exploremore.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exploremore.pojo.UserPojo;
import com.exploremore.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired 
	UserService userService;
	
	@PostMapping("user-info/login")
	public UserPojo login(@RequestBody UserPojo userPojo) {
		return userService.login(userPojo);
	}
	
	@PostMapping("user-info/register")
	public UserPojo register(@RequestBody UserPojo userPojo) {
		return userService.register(userPojo);
	}	
}

