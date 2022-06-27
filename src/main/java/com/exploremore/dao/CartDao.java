package com.exploremore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploremore.entity.CartCourseEntity;


@Repository
public interface CartDao extends JpaRepository<CartCourseEntity, Integer> {
	List<CartCourseEntity> findByCartId(int cart_id);

}
