package com.exploremore.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exploremore.entity.CartCourseEntity;

public interface CartCourseDao extends JpaRepository<CartCourseEntity, Integer> {

	List<CartCourseEntity> findByCartId(int cart_id);

}
