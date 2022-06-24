package com.exploremore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exploremore.entity.OrderEntity;

public interface OrderDao extends JpaRepository<OrderEntity, Integer>{

	List<OrderEntity> findByOrderId(int id);
	
}
