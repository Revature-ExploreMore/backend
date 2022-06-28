package com.exploremore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exploremore.entity.CartEntity;

public interface CartDao extends JpaRepository<CartEntity, Integer>  {
	CartEntity findByUserId(int user_id);

//	List<CartCourseEntity> findById(int cart_id);
}
