package com.exploremore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exploremore.dao.UserDao;
import com.exploremore.entity.UserEntity;
import com.exploremore.pojo.UserPojo;
import com.exploremore.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	UserServiceImpl userService;
	
	private UserPojo expectedPojo;
	private UserEntity dummyEntity;
	
	@BeforeEach
	public void setup() {
		expectedPojo = new UserPojo(1, "Goldendeep", "golden@coolkids.com", "333-343-3434", "golden", "kaur11", false,
				LocalDateTime.parse("2022-06-25T22:37:24.894"), 2);
		dummyEntity = new UserEntity(1, "Goldendeep", "golden@coolkids.com", "333-343-3434", "golden", "kaur11", false,
				LocalDateTime.parse("2022-06-25T22:37:24.894"), 2);
	}
	
	@DisplayName("JUnit test for Get User")
	@Test
	public void testGetUser() {
	   	when(userDao.findById(1)).thenReturn(Optional.of(dummyEntity));
    	UserPojo actualUserPojo = userService.getUser(1);
    	assertEquals(expectedPojo.getId(), actualUserPojo.getId());
    }

}
