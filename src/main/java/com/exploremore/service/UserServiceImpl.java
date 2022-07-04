package com.exploremore.service;

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
		List<UserEntity> userEntityLogin = userDao.findByUsernameAndPassword(userPojo.getUsername(), userPojo.getPassword());
		UserPojo validLoginPojo = null;
		
		if(userEntityLogin.isEmpty()) {
			System.out.println("need exception handling here");
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
}
