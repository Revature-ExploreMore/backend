
package com.exploremore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exploremore.entity.CartEntity;
public interface CartDao extends JpaRepository<CartEntity, Integer>  {
	Optional <CartEntity> findByUserId(int user_id);

//	List<CartCourseEntity> findById(int cart_id);
	
}

