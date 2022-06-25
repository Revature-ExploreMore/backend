package com.exploremore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.exploremore.entity.BillingEntity;

public interface BillingDao extends JpaRepository<BillingEntity,Integer>{
=======
import org.springframework.stereotype.Repository;

import com.exploremore.entity.BillingEntity;

@Repository
public interface BillingDao extends JpaRepository<BillingEntity, Integer>{
>>>>>>> cd114d30817c51d2b6f5fa19c39c2f6ececbf352

}
