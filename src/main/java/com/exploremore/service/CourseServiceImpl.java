package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.CourseDao;
import com.exploremore.entity.CourseEntity;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.pojo.CoursePojo;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseDao courseDao;

	// gets all courses
	@Override
	public List<CoursePojo> getAllCourses() {
		List<CourseEntity> allCoursesEntity = courseDao.findAll();
		List<CoursePojo> allCoursesPojo = new ArrayList<CoursePojo>();
		for (CourseEntity fetchedEntity : allCoursesEntity) {
			CategoryPojo category = new CategoryPojo();
			category.setId(fetchedEntity.getCategoryId().getId());
			category.setCategoryName(fetchedEntity.getCategoryId().getCategoryName());
			CoursePojo currCourse = new CoursePojo(fetchedEntity.getId(), fetchedEntity.getName(),
					fetchedEntity.getDescription(), fetchedEntity.getPrice(), 
					fetchedEntity.getImageUrl());
			currCourse.setCategoryId(category);
			allCoursesPojo.add(currCourse);
		}
		return allCoursesPojo;
	}

}
