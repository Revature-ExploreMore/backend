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

	List<CoursePojo> getAllCourses();

	CoursePojo getACourseById(int id);

	CoursePojo getACourseByCategory(String name);

	CoursePojo getCourseById(int id);

	List<CoursePojo> getAllByCategory(String categoryName);
 	
}
