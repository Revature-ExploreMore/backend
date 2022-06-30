package com.exploremore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exploremore.entity.OrderCourseEntity;
import com.exploremore.entity.UserEntity;

@Repository
public interface OrderCourseDao extends JpaRepository<OrderCourseEntity, Integer> {
	@Query("SELECT oc FROM OrderCourseEntity oc JOIN oc.order o WHERE o.user.id = ?1")
	List<OrderCourseEntity> findOrderCourseByUser(int userId);
}
