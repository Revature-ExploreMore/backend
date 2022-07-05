package com.exploremore.service;

import org.springframework.stereotype.Service;
import com.exploremore.pojo.UserPojo;

@Service
public interface UserService {
	
	UserPojo register(UserPojo userpojo);
	
	UserPojo login(UserPojo userpojo);

	UserPojo updateUser(UserPojo userPojo);
	
//	UserPojo getUser (int id);
	
}
