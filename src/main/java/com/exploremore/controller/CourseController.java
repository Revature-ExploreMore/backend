package com.exploremore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CoursePojo;
import com.exploremore.service.CourseService;

@CrossOrigin // to enable cors
@RestController
@RequestMapping("course")
public class CourseController {
	//1. addCourse Fozeya-Nikka Alviar
	//2. getACourse Logan
	//3. getCourseByCategory(returns a list of courses with that category) Kassandra
	//4. getCourseById Kassandra
	//5. getAllCourses -- Not in responsibilities---- suggested
	
	@Autowired
	CourseService courseService;
	// create the rest methods for the rest endpoints
	
	// add a Course
	@PutMapping("courses")
	public CoursePojo addCourse(CoursePojo coursePojo) throws GlobalException {
		return courseService.addCourse(coursePojo);
		
	}

	@GetMapping("getAll")
	public List<CoursePojo> getAllCourses(){
		return courseService.getAllCourses();
	}

	@GetMapping("getById/{id}")
	public CoursePojo getById(@PathVariable("id")int id) throws GlobalException{
		return courseService.getCourseById(id);
	}
	
	@GetMapping("getByCategory/{category}")
	public List<CoursePojo> getCourseByCategory(@PathVariable("category") String categoryName) throws GlobalException{
		return courseService.getAllByCategory(categoryName);
	}
}

