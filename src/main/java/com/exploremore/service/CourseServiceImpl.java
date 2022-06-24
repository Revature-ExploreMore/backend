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

	@Autowired
	CourseDao courseDao;
	
	public CourseServiceImpl() {
		
	}

	@Override
	public CoursePojo getCourseById(int id) {
		Optional<CourseEntity> courseEntityOpt = courseDao.findById(id);
		CoursePojo coursePojo = null;
		if(courseEntityOpt.isPresent()) {
			CourseEntity fetchedCourseEntity = courseEntityOpt.get();
			coursePojo = new CoursePojo();
			BeanUtils.copyProperties(fetchedCourseEntity, coursePojo);
		}
		return coursePojo;
	}

	@Override
	public List<CoursePojo> getAllByCategory(String categoryName) {
		List<CourseEntity> allCoursesEntity = courseDao.findByCategoryId_CategoryName(categoryName);
		List<CoursePojo> allCoursesPojo = new ArrayList<CoursePojo>();
		for(CourseEntity fetchedCoursesEntity: allCoursesEntity) {
			CoursePojo returnCoursePojo = new CoursePojo();
			
			
			
			returnCoursePojo.setId(fetchedCoursesEntity.getId());
			returnCoursePojo.setName(fetchedCoursesEntity.getName());
			returnCoursePojo.setDescription(fetchedCoursesEntity.getDescription());
			returnCoursePojo.setPrice(fetchedCoursesEntity.getPrice());
			returnCoursePojo.setImageUrl(fetchedCoursesEntity.getImageUrl());
			
			CategoryPojo catPojo = new CategoryPojo();
			catPojo.setId(fetchedCoursesEntity.getCategoryId().getId());
			catPojo.setCategoryName(fetchedCoursesEntity.getCategoryId().getCategoryName());
			
			returnCoursePojo.setCategoryId(catPojo);
		
			allCoursesPojo.add(returnCoursePojo);
		}
		return allCoursesPojo;
	}
	


}


























