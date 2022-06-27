package com.exploremore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exploremore.entity.BillingEntity;

@Repository
public interface BillingDao extends JpaRepository<BillingEntity, Integer>{

}
