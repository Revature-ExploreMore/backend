package com.exploremore;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import com.exploremore.dao.CategoryDao;
import com.exploremore.entity.CategoryEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.service.CategoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CategoryTest {

	@Mock
	CategoryDao categoryDao;
	
	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;
	
//	private CategoryPojo testCategory;
	
	@DisplayName("JUnit get all categories")
	@Test
	public void testGetAllCategories() throws GlobalException{
		List<CategoryEntity> allCategoriesEntity = new ArrayList<CategoryEntity>();
		allCategoriesEntity.add(new CategoryEntity(1,"math"));
		allCategoriesEntity.add(new CategoryEntity(2,"science"));
		when(categoryDao.findAll()).thenReturn(allCategoriesEntity);
		List<CategoryPojo> returnedCourses = categoryServiceImpl.getAllCategories();
		assertEquals(2, returnedCourses.size());
	}
	
//	@DisplayName("JUnit add new category")
//	@Test
//	public void testAddNewCategory(CategoryPojo categoryPojo) throws GlobalException{
//		List<CategoryEntity> allCategoriesEntity = new ArrayList<CategoryEntity>();
//		allCategoriesEntity.add(new CategoryEntity(1, "math"));
//		testCategory = new CategoryPojo(7,"philosophy");
//		CategoryPojo addedCategory = categoryServiceImpl.addNewCategory(testCategory);
//		when(categoryDao.findAll()).thenReturn(allCategoriesEntity);
//		List<CategoryPojo> returnedCourses = categoryServiceImpl.getAllCategories();
//		assertEquals(2, returnedCourses.size());
//	}
}











