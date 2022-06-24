package com.exploremore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploremore.entity.CourseEntity;

@Repository
public interface CourseDao extends JpaRepository<CourseEntity, Integer>{


	List<CourseEntity> findByCategoryId_CategoryName(String categoryName);

}
