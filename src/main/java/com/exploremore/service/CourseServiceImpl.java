package com.exploremore.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exploremore.dao.CourseDao;
import com.exploremore.entity.CourseEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.pojo.CoursePojo;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseDao courseDao;

	// gets all courses
	@Override
	public List<CoursePojo> getAllCourses() throws GlobalException{
		List<CourseEntity> allCoursesEntity = courseDao.findAll();
		List<CoursePojo> allCoursesPojo = new ArrayList<CoursePojo>();
		for (CourseEntity fetchedEntity : allCoursesEntity) {
			CategoryPojo category = new CategoryPojo();	   
			BeanUtils.copyProperties(fetchedEntity.getCategory(), category);
			CoursePojo currCourse = new CoursePojo();
			BeanUtils.copyProperties(fetchedEntity, currCourse);
			currCourse.setCategory(category);
			allCoursesPojo.add(currCourse);
		}
		return allCoursesPojo;
	}

	@Override
	public CoursePojo getCourseById(int id) throws GlobalException{
		Optional<CourseEntity> courseEntityOpt = courseDao.findById(id);
		CoursePojo coursePojo = null;
		if(courseEntityOpt.isPresent()) {
			CourseEntity fetchedCourseEntity = courseEntityOpt.get();
			coursePojo = new CoursePojo();
			BeanUtils.copyProperties(fetchedCourseEntity, coursePojo);
			
			CategoryPojo category = new CategoryPojo();
			BeanUtils.copyProperties(fetchedCourseEntity.getCategory(), category);
			coursePojo.setCategory(category);
			
		}
		return coursePojo;
	}
	
	@Override
	public List<CoursePojo> getAllByCategory(String categoryName) throws GlobalException{
		List<CourseEntity> allCoursesEntity = courseDao.findByCategoryId_CategoryName(categoryName);
		List<CoursePojo> allCoursesPojo = new ArrayList<CoursePojo>();
		for(CourseEntity fetchedCoursesEntity: allCoursesEntity) {
			
			CoursePojo returnCoursePojo = new CoursePojo();	
			returnCoursePojo.setId(fetchedCoursesEntity.getId());
			returnCoursePojo.setName(fetchedCoursesEntity.getName());
			returnCoursePojo.setDescription(fetchedCoursesEntity.getDescription());
			returnCoursePojo.setPrice(fetchedCoursesEntity.getPrice());
			returnCoursePojo.setImageUrl(fetchedCoursesEntity.getImageUrl());		
			allCoursesPojo.add(returnCoursePojo);
			
			CategoryPojo category = new CategoryPojo();	   
			BeanUtils.copyProperties(fetchedCoursesEntity.getCategory(), category);
			returnCoursePojo.setCategory(category);
			
		}
		return allCoursesPojo;
	}
	

	@Override
	public CoursePojo addCourse(CoursePojo coursePojo) throws GlobalException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCourse(int id) throws GlobalException {
		courseDao.deleteById(id);
		return true;
	}

	@Override
	public CoursePojo updateCourse(CoursePojo coursePojo) throws GlobalException {
		// copy the pojo into an entity object
		CourseEntity courseEntity = new CourseEntity();
		BeanUtils.copyProperties(coursePojo, courseEntity);
		
		//  now pass the courseEntity object to spring data jpa to be updated into the table
		CourseEntity returnedCourseEntity = courseDao.save(courseEntity);
				
		return coursePojo;
	}
}









