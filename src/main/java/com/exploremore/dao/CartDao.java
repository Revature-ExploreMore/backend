package com.exploremore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploremore.entity.CartCourseEntity;
import com.exploremore.entity.CartEntity;

@Repository
public interface CartDao extends JpaRepository<CartEntity, Integer> {
	List<CartCourseEntity> findByCartId(int id);

}
