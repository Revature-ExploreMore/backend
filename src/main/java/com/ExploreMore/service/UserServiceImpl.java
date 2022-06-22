package com.ExploreMore.service;

import org.springframework.beans.BeanUtils;

import com.ExploreMore.dao.UserDao;
import com.ExploreMore.entity.UserEntity;
import com.ExploreMore.pojo.UserPojo;

public class UserServiceImpl implements UserService {
	
	UserDao userDao;

	@Override
	public UserPojo registerUser(UserPojo userPojo) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, userEntity);
		
		return null;
	}

	@Override
	public UserPojo login(UserPojo userpojo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
