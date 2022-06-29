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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.exploremore.dao.CourseDao;
import com.exploremore.dao.UserDao;
import com.exploremore.entity.CategoryEntity;
import com.exploremore.entity.CourseEntity;
import com.exploremore.entity.UserEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CoursePojo;
import com.exploremore.pojo.UserPojo;
import com.exploremore.service.CourseServiceImpl;
import com.exploremore.service.UserServiceImpl;
@ExtendWith(MockitoExtension.class)
public class CourseTest {
	@Mock
	CourseDao courseDao;
	
	@InjectMocks
	CourseServiceImpl courseServiceImpl;
	
	private CoursePojo expectedCourse;
	private Optional<CourseEntity> dummyCourse;
	
	@DisplayName("JUnit get all Courses")
	@Test
	public void testGetAllCourses() throws GlobalException{
		List<CourseEntity> allCourseEntity = new ArrayList<CourseEntity>();
		CategoryEntity catEntity = new CategoryEntity(1, "math");
		allCourseEntity.add(new CourseEntity(1, "math 101", "learn math!", 10, "", catEntity));
		allCourseEntity.add(new CourseEntity(2, "math 102", "learn harder math!", 15, "", catEntity));
		when(courseDao.findAll()).thenReturn(allCourseEntity);
		List<CoursePojo> returnedCourses = courseServiceImpl.getAllCourses();
		assertEquals(2, returnedCourses.size());
	}
	
	@DisplayName("JUnit get course by id")
	@Test
	public void testGetCourseById() throws GlobalException {
		CategoryEntity catEntity = new CategoryEntity(1, "math");
		dummyCourse = Optional.of(new CourseEntity(1, "math 101", "learn math!", 10, "", catEntity));
		when(courseDao.findById(1)).thenReturn(dummyCourse);
		CoursePojo requestedCourse = courseServiceImpl.getCourseById(1);
		assertEquals(requestedCourse.getName(), "math 101");
		
	}
	
	@DisplayName("JUnit get all courses by category") //test passes
	@Test
	public void testGetAllCoursesByCategory() throws GlobalException {
		List<CourseEntity> allCourseByCategoryEntity = new ArrayList<CourseEntity>();
		CategoryEntity catEntity = new CategoryEntity(1, "math");
		allCourseByCategoryEntity.add(new CourseEntity(1, "math 101", "learn math!", 10, "", catEntity));
		allCourseByCategoryEntity.add(new CourseEntity(2, "math 102", "learn harder math!", 15, "", catEntity));
		when(courseDao.findByCategoryId_CategoryName("math")).thenReturn(allCourseByCategoryEntity);
		List<CoursePojo> returnedCourses = courseServiceImpl.getAllByCategory("math");
		assertEquals(2, returnedCourses.size());
	}
	
	
}
