package com.exploremore.service;

import java.util.List;
<<<<<<< HEAD

import com.exploremore.pojo.CoursePojo;

public interface CourseService {

	CoursePojo addCourse(CoursePojo coursePojo);

	List<CoursePojo> getAllCourses();

	CoursePojo getACourseById(int id);

	CoursePojo getACourseByCategory(String name);


=======

import com.exploremore.pojo.CoursePojo;

public interface CourseService {
	//gets all courses
		List<CoursePojo> getAllCourses();
		

	CoursePojo getCourseById( int id);
	
	List<CoursePojo> getAllByCategory(String categoryName);
 	
>>>>>>> 6f72f212e5d4aedee3443c1a52992bc4fb1181f2
}
