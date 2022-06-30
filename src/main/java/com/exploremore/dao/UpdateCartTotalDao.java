package com.exploremore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exploremore.entity.CartEntity;

public interface UpdateCartTotalDao extends JpaRepository<CartEntity, Integer>{

}
