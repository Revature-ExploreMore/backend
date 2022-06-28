package com.exploremore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CoursePojo;
import com.exploremore.service.CourseService;


@CrossOrigin(origins="*") // to enable cors
@RestController
@RequestMapping("course")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@GetMapping("getAll")
	public List<CoursePojo> getAllCourses(){
		return courseService.getAllCourses();
	}
	//uncomment if method is needed
//	@GetMapping("getById/{id}")
//	public CoursePojo getById(@PathVariable("id")int id){
//		return courseService.getCourseById(id);
//	}
	//does not return anything
	@GetMapping("getByCategory/{category}")
	public List<CoursePojo> getCourseByCategory(@PathVariable("category") String categoryName) throws GlobalException{
		return courseService.getAllByCategory(categoryName);
	}
}
