package com.exploremore.service;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exploremore.dao.UserDao;
import com.exploremore.entity.UserEntity;
import com.exploremore.pojo.UserPojo;

@Service
public class UserServiceImpl implements UserService{
	
	final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDao userDao;

	@Override
	public UserPojo register(UserPojo userPojo) {
		String pass = userPojo.getPassword();
		userPojo.setPassword(PasswordHashing.doHashing(pass));
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, userEntity);
		UserEntity returnedUserEntity = userDao.saveAndFlush(userEntity);
		userPojo.setId(returnedUserEntity.getId());
		return userPojo;
	}

	@Override
	public UserPojo login(UserPojo userPojo) {
		String pass = userPojo.getPassword();
		userPojo.setPassword(PasswordHashing.doHashing(pass));
		List<UserEntity> userEntityLogin = userDao.findByUsernameAndPassword(userPojo.getUsername(), userPojo.getPassword());
		UserPojo validLoginPojo = null;
		
		if(userEntityLogin.isEmpty()) {
			System.out.println("exception here");
		} else {
			for(UserEntity fetchedUserEntity : userEntityLogin) {
				UserPojo loginUserPojo = new UserPojo(fetchedUserEntity.getId(), fetchedUserEntity.getName(), 
					fetchedUserEntity.getEmail(), fetchedUserEntity.getPhoneNumber(), 
					fetchedUserEntity.getUsername(), fetchedUserEntity.getPassword(), fetchedUserEntity.isDarkModePreference(), 
					fetchedUserEntity.getRegisterDate(), fetchedUserEntity.getRoleId());
					validLoginPojo = loginUserPojo;
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
	
	public static void main(String[] args) {
		String pass1 = "pass";
		String returned = "";
		returned = PasswordHashing.doHashing(pass1);
		System.out.println(returned);
		
		LocalDateTime time = LocalDateTime.now();
		UserPojo userPojo1 = new UserPojo(100,"john", "john@test.com", "333-444-5555", "johnny", "johnboy12345678", false, time, 2);
		System.out.println(userPojo1);
		String pass2 = userPojo1.getPassword();
		userPojo1.setPassword(PasswordHashing.doHashing(pass2));
		System.out.println(userPojo1);
		
		// why is hashing working here, but not working for register function?
	}
}
