package com.exploremore.service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exploremore.dao.UserDao;
import com.exploremore.entity.UserEntity;
import com.exploremore.pojo.UserPojo;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public UserPojo register(UserPojo userPojo) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, userEntity);
		userEntity.setPassword(encoder.encode(userPojo.getPassword()));
		UserEntity returnedUserEntity = userDao.saveAndFlush(userEntity);
		userPojo.setId(returnedUserEntity.getId());
		return userPojo;
	}

	@Override
	public UserPojo login(UserPojo userPojo) {

		Optional<UserEntity> userEntOpt = userDao.findByUsername(userPojo.getUsername());
		UserPojo validLoginPojo = null;
		
		if(userEntOpt.isEmpty()) {
			System.out.println("need exception handling here");

		} else {
			UserEntity user = userEntOpt.get();
			if(encoder.matches(userPojo.getPassword(), user.getPassword())) {
				UserPojo loginUserPojo = new UserPojo(user.getId(), user.getName(), 
				user.getEmail(), user.getPhoneNumber(), 
				user.getUsername(), user.getPassword(), user.isDarkModePreference(), 
				user.getRegisterDate(), user.getRoleId());
				validLoginPojo = loginUserPojo;
			} else {
				System.out.println("need exception handling here 2");
			}
		}
		return validLoginPojo;
	}

	@Override
	public UserPojo updateUser(UserPojo userPojo) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, userEntity);
		UserEntity returnedUserEntity = userDao.save(userEntity);
		BeanUtils.copyProperties(returnedUserEntity, userPojo);

		return userPojo;
	}
	
	@Override
	public UserPojo getUser(int uId) {
		Optional<UserEntity> userEntity = userDao.findById(uId);
		UserPojo userPojo = null;
		if(userEntity.isPresent()) {
			
			UserEntity fetchedUserEntity = userEntity.get();
			userPojo = new UserPojo();
			BeanUtils.copyProperties(fetchedUserEntity, userPojo);
		}
		return userPojo;
	}
		
}

