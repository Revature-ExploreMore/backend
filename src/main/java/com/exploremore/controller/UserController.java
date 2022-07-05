package com.exploremore.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exploremore.pojo.UserPojo;
import com.exploremore.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
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
	@PutMapping("user-info/updateUser")
	public UserPojo updateUser(@RequestBody UserPojo userPojo) {
		return userService.updateUser(userPojo);
	}
//	@GetMapping("userInfo/{uid}")
//	public UserPojo getUser(@PathVariable("uid") int uId) {
//		return userService.getUser(int id);
//	}
}

