package com.exploremore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploremore.entity.CategoryEntity;
import com.exploremore.entity.CourseEntity;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Integer>{

}
