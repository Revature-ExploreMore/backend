package com.exploremore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exploremore.entity.CartCourseEntity;

@Repository
public interface CartDao {
	List<CartCourseEntity> findByCartId(int cart_id);

}
