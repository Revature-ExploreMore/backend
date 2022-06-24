package com.exploremore.service;

import java.util.List;

import com.exploremore.pojo.CoursePojo;

public interface CourseService {

	CoursePojo addCourse(CoursePojo coursePojo);

	List<CoursePojo> getAllCourses();

	CoursePojo getACourseById(int id);

	CoursePojo getACourseByCategory(String name);


}
