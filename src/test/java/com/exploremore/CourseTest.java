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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.exploremore.dao.CourseDao;
import com.exploremore.entity.CategoryEntity;
import com.exploremore.entity.CourseEntity;
import com.exploremore.exceptions.CourseNotFoundException;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.pojo.CoursePojo;
import com.exploremore.service.CourseServiceImpl;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@ExtendWith(MockitoExtension.class)
public class CourseTest {
	@Mock
	CourseDao courseDao;
	
	@InjectMocks
	CourseServiceImpl courseServiceImpl;
	
	private Optional<CourseEntity> dummyCourse;
	private CategoryEntity  categoryEntity;
	private CourseEntity dummyCourseEntity;
	private CategoryPojo  categoryPojo;
	private CoursePojo coursePojo;
	private CartCoursePojo cartCoursePojo;
	private CartPojo cartPojo;
	LocalDateTime time = LocalDateTime.now();
	BigDecimal var = BigDecimal.valueOf(0.0);
	
	@BeforeEach
	public void setup() {
		cartPojo = new CartPojo(2, time, time, false, var, 11, 1 );
		categoryEntity = new CategoryEntity(1, "math");
		dummyCourseEntity = new CourseEntity(1, "math 101", "learn math", 35, "", categoryEntity) ;
		categoryPojo = new CategoryPojo(1, "math");
		coursePojo = new CoursePojo(1, "math 101", "learn math", 35, "", categoryPojo);
		cartCoursePojo = new CartCoursePojo(1,coursePojo,cartPojo);		
	}
	
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

//  *** function was removed from the project ***
//	JUnit Testing for Delete Course
//	@DisplayName("JUnit test for deleteCourse method") //test passed
//	@Test
//	public void testDeleteCourse() throws GlobalException, CourseNotFoundException {
//		doNothing().when(courseDao).deleteById(1);
//		courseServiceImpl.deleteCourse(1);
//		verify(courseDao, times(1)).deleteById(1);
//	}
	
	//JUnit Testing for Update Course
	@DisplayName("JUnit test for updateCourse method") 
	@Test
	public void testUpdateCourse() throws GlobalException {
		when(courseDao.save(any(CourseEntity.class))).thenReturn(dummyCourseEntity);
		CategoryPojo sendCategoryPojo =new CategoryPojo(1,"math");
		CoursePojo sendCoursePojo = new CoursePojo(1, "math 101", "learn math", 35, "",sendCategoryPojo,cartCoursePojo);
		CoursePojo actualCoursePojo = courseServiceImpl.updateCourse(sendCoursePojo);
		assertEquals(coursePojo.getId(),actualCoursePojo.getId());
		assertEquals(coursePojo.getName(),actualCoursePojo.getName());
		assertEquals(coursePojo.getDescription(),actualCoursePojo.getDescription());
		assertEquals(coursePojo.getImageUrl(),actualCoursePojo.getImageUrl());
	}
	
	@DisplayName("JUnit test for addNewCourse method") 
	@Test
	public void testAddNewCourse() throws GlobalException {
		when(courseDao.saveAndFlush(any(CourseEntity.class))).thenReturn(dummyCourseEntity);
		CategoryPojo sendCategoryPojo =new CategoryPojo(1,"math");
		CoursePojo sendCoursePojo = new CoursePojo(1, "math 101", "learn math", 35, "",sendCategoryPojo);
		CoursePojo actualCoursePojo = courseServiceImpl.addNewCourse(sendCoursePojo);
		assertEquals(sendCoursePojo, actualCoursePojo);
	}			
}
