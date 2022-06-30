package com.exploremore.service;

import java.util.List;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CategoryPojo;

public interface CategoryService {

	List<CategoryPojo> getAllCategories() throws GlobalException;
	
	CategoryPojo addNewCategory(CategoryPojo categoryPojo) throws GlobalException;
}
