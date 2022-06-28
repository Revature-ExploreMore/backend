package com.exploremore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploremore.service.CategoryService;

@CrossOrigin // to enable cors
@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
}
