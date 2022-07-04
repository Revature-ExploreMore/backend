package com.exploremore.service;

import java.util.List;
import java.util.Optional;

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
//		List<UserEntity> userEntityLogin = userDao.findByUsernameAndPassword(userPojo.getUsername(), userPojo.getPassword());
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
		
//		if(userEntityLogin.isEmpty()) {
//			System.out.println("need exception handling here");
//		} else {
//			for(UserEntity fetchedUserEntity : userEntityLogin) {
//				UserPojo loginUserPojo = new UserPojo(fetchedUserEntity.getId(), fetchedUserEntity.getName(), 
//					fetchedUserEntity.getEmail(), fetchedUserEntity.getPhoneNumber(), 
//					fetchedUserEntity.getUsername(), fetchedUserEntity.getPassword(), fetchedUserEntity.isDarkModePreference(), 
//					fetchedUserEntity.getRegisterDate(), fetchedUserEntity.getRoleId());
//					validLoginPojo = loginUserPojo;
//				}
//		}
		return validLoginPojo;
	}

}
