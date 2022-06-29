package com.exploremore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.service.CategoryService;

@CrossOrigin // to enable cors
@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("getCategories")
	public List<CategoryPojo> getAllCategories() throws GlobalException{
		return categoryService.getAllCategories();
	}
	
//	@PostMapping("addCategory")
//	public CategoryPojo addNewCategory(@RequestBody CategoryPojo categoryPojo) throws GlobalException {
//		return categoryService.addNewCategory(categoryPojo);
//	}
}
