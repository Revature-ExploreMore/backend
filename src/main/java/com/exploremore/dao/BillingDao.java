package com.exploremore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exploremore.entity.BillingEntity;

public interface BillingDao extends JpaRepository<BillingEntity,Integer>{

}
