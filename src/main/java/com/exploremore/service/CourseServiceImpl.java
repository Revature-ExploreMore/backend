package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.CourseDao;
import com.exploremore.entity.CategoryEntity;
import com.exploremore.entity.CourseEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.pojo.CoursePojo;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseDao courseDao;
	
	
//  delete course will not work with current tables, need to have a different way of "deleting course"
//  solution is to have a disabled column in courses so it can be filtered with available courses
//	@Override
//	public boolean deleteCourse(int id) throws GlobalException {
//		courseDao.deleteById(id);
//		return true;
//	}
	
	// gets all courses
	@Override
	public List<CoursePojo> getAllCourses() throws GlobalException{
		List<CourseEntity> allCoursesEntity = courseDao.findAll();
		List<CoursePojo> allCoursesPojo = new ArrayList<CoursePojo>();
		for (CourseEntity fetchedEntity : allCoursesEntity) {

			CategoryPojo category = new CategoryPojo();
			category.setId(fetchedEntity.getCategory().getId());
			category.setCategoryName(fetchedEntity.getCategory().getCategoryName());
			CoursePojo currCourse = new CoursePojo(fetchedEntity.getId(), fetchedEntity.getName(),
					fetchedEntity.getDescription(), fetchedEntity.getPrice(), fetchedEntity.getImageUrl());
			currCourse.setCategoryId(category);
			allCoursesPojo.add(currCourse);
		}
		return allCoursesPojo;
	}
	
	public CourseServiceImpl() {
	}

	@Override
	public CoursePojo getCourseById(int id) throws GlobalException{
		Optional<CourseEntity> courseEntityOpt = courseDao.findById(id);
		CoursePojo coursePojo = null;
		if (courseEntityOpt.isPresent()) {
			CourseEntity fetchedCourseEntity = courseEntityOpt.get();
			coursePojo = new CoursePojo();
			BeanUtils.copyProperties(fetchedCourseEntity, coursePojo);
			CategoryPojo catPojo = new CategoryPojo();
			catPojo.setId(fetchedCourseEntity.getCategory().getId());
			catPojo.setCategoryName(fetchedCourseEntity.getCategory().getCategoryName());
			coursePojo.setCategoryId(catPojo);
		}
		return coursePojo;
	}

	@Override
	public List<CoursePojo> getAllByCategory(String categoryName) throws GlobalException{
		List<CourseEntity> allCoursesEntity = courseDao.findByCategoryId_CategoryName(categoryName);
		List<CoursePojo> allCoursesPojo = new ArrayList<CoursePojo>();
		for (CourseEntity fetchedCoursesEntity : allCoursesEntity) {
			CoursePojo returnCoursePojo = new CoursePojo();
			returnCoursePojo.setId(fetchedCoursesEntity.getId());
			returnCoursePojo.setName(fetchedCoursesEntity.getName());
			returnCoursePojo.setDescription(fetchedCoursesEntity.getDescription());
			returnCoursePojo.setPrice(fetchedCoursesEntity.getPrice());
			returnCoursePojo.setImageUrl(fetchedCoursesEntity.getImageUrl());
			CategoryPojo catPojo = new CategoryPojo();
			catPojo.setId(fetchedCoursesEntity.getCategory().getId());
			catPojo.setCategoryName(fetchedCoursesEntity.getCategory().getCategoryName());
			returnCoursePojo.setCategoryId(catPojo);
			allCoursesPojo.add(returnCoursePojo);
		}
		return allCoursesPojo;
	}

	@Override
	public CoursePojo addNewCourse(CoursePojo coursePojo) throws GlobalException{
		CourseEntity courseEntity = new CourseEntity();
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(coursePojo.getCategory().getId());
		categoryEntity.setCategoryName(coursePojo.getCategory().getCategoryName());
		courseEntity.setCategory(categoryEntity);
		BeanUtils.copyProperties(coursePojo, courseEntity);
		CourseEntity newCourseEntity = courseDao.saveAndFlush(courseEntity);
		coursePojo.setId(newCourseEntity.getId());
		return coursePojo;
	}

	@Override
	public CoursePojo updateCourse(CoursePojo coursePojo) throws GlobalException {
		CourseEntity courseEntity = new CourseEntity();
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(coursePojo.getCategory().getId());
		categoryEntity.setCategoryName(coursePojo.getCategory().getCategoryName());
		courseEntity.setCategory(categoryEntity);
		BeanUtils.copyProperties(coursePojo, courseEntity);
		courseDao.save(courseEntity);
		return coursePojo;
	}
}
