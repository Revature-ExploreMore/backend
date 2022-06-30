package com.exploremore.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exploremore.entity.CartCourseEntity;

public interface CartCourseDao extends JpaRepository<CartCourseEntity, Integer> {

	List<CartCourseEntity> findByCartId(int cart_id);
	@Query(value = "INSERT INTO cart_course_details (course_id, cart_id) VALUES (?1, ?2) returning id;", nativeQuery = true)
	int saveByCourseIdAndCartId(int course_id, int cart_id);

}
