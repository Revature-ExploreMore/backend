package com.exploremore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CoursePojo;
import com.exploremore.service.CourseService;

@CrossOrigin
@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	CourseService courseService;
	// create the rest methods for the rest endpoints
	
	@GetMapping("getAll")
	public List<CoursePojo> getAllCourses() throws GlobalException{
		return courseService.getAllCourses();
	}

	// gets a course by id
	@GetMapping("getById/{id}")
	public CoursePojo getById(@PathVariable("id") int id) throws GlobalException {
		return courseService.getCourseById(id);
	}

	@GetMapping("getByCategory/{category}")
	public List<CoursePojo> getCourseByCategory(@PathVariable("category") String categoryName) throws GlobalException {
		return courseService.getAllByCategory(categoryName);
	}

	@PostMapping("addNewCourse")
	public CoursePojo addNewCourse(@RequestBody CoursePojo coursePojo) throws GlobalException {
		return courseService.addNewCourse(coursePojo);
	}
}
