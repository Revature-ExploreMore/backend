package com.exploremore;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.List;
import com.exploremore.dao.UserDao;
import com.exploremore.entity.UserEntity;
import com.exploremore.pojo.UserPojo;
import com.exploremore.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class LoginAndRegisterTest {

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

	@DisplayName("JUnit Test for User Registration")
	@Test
	public void testUserRegistration() {
		when(userDao.saveAndFlush(any(UserEntity.class))).thenReturn(dummyEntity);
		UserPojo sentRegistration = new UserPojo(1, "Goldendeep", "golden@coolkids.com", "333-343-3434", "golden",
				"kaur11", false, LocalDateTime.parse("2022-06-25T22:37:24.894"), 2);
		UserPojo actualRegistration = userService.register(sentRegistration);
		assertEquals(1, actualRegistration.getId());
	}

	@DisplayName("JUnit Test for User Login")
	@Test
	public void testUserLogin() {
		when(userDao.findByUsernameAndPassword(dummyEntity.getUsername(), dummyEntity.getPassword()))
				.thenReturn(List.of(dummyEntity));
		UserPojo actualRegistration = userService.login(expectedPojo);
		assertEquals("golden", actualRegistration.getUsername());
	}

}
