package com.exploremore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.pojo.CoursePojo;
import com.exploremore.service.CourseService;


@CrossOrigin // to enable cors
@RestController
@RequestMapping("api")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@GetMapping("course/getall")
	public List<CoursePojo> getAllCourses(){
		return courseService.getAllCourses();
	}
}
