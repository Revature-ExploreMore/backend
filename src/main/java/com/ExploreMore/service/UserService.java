package com.ExploreMore.service;

import com.ExploreMore.pojo.UserPojo;

public interface UserService {

	UserPojo registerUser(UserPojo userpojo);
	
	UserPojo login(UserPojo userpojo);
}
