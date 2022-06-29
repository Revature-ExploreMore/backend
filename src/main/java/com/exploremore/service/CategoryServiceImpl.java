package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.CategoryDao;
import com.exploremore.entity.CategoryEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CategoryPojo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;

	@Override
	public List<CategoryPojo> getAllCategories() throws GlobalException {
		List<CategoryEntity> allCategoriesEntity = categoryDao.findAll();
		List<CategoryPojo> allCategoriesPojo = new ArrayList<CategoryPojo>();
		for(CategoryEntity categories : allCategoriesEntity) {
			CategoryPojo catPojo = new CategoryPojo();
			BeanUtils.copyProperties(categories, catPojo);
			allCategoriesPojo.add(catPojo);
		}
		return allCategoriesPojo;
	}

	@Override
	public CategoryPojo addNewCategory(CategoryPojo categoryPojo) throws GlobalException {
		CategoryEntity categoryEntity = new CategoryEntity();
		BeanUtils.copyProperties(categoryPojo, categoryEntity);
		CategoryEntity returnedCategoryEntity = categoryDao.saveAndFlush(categoryEntity);
		categoryPojo.setId(returnedCategoryEntity.getId());
		return categoryPojo;
	}
}

