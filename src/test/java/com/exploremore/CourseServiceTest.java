package com.exploremore;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exploremore.dao.CourseDao;
import com.exploremore.service.CourseServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

	@Mock
	CourseDao courseDao;
	
	@InjectMocks
	CourseServiceImpl courseService;
	
}
