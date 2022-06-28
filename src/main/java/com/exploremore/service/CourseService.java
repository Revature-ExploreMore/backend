package com.exploremore.service;

import java.util.List;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CoursePojo;

public interface CourseService {
	//gets all courses
		List<CoursePojo> getAllCourses();
		
		// uncomment if method needed
	//CoursePojo getCourseById( int id);
	
	List<CoursePojo> getAllByCategory(String categoryName) throws GlobalException;

	CoursePojo addCourse(CoursePojo coursePojo);

	CoursePojo getCourseById(int id);

	boolean deleteCourse(int id) throws GlobalException;
	
	CoursePojo updateCourse(CoursePojo coursePojo) throws GlobalException;


}
