package com.exploremore.service;

import java.util.List;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CoursePojo;

public interface CourseService {
	//gets all courses
	List<CoursePojo> getAllCourses() throws GlobalException;
		
	
	CoursePojo getCourseById(int id);
	
	List<CoursePojo> getAllByCategory(String categoryName) throws GlobalException;
	
	CoursePojo addCourse(CoursePojo coursePojo) throws GlobalException;

	boolean deleteCourse(int id) throws GlobalException;
	
	CoursePojo updateCourse(CoursePojo coursePojo) throws GlobalException;


 	
}
