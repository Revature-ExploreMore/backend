<<<<<<< HEAD
//package com.exploremore.dao;
//
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.exploremore.entity.OrderEntity;
//
//public interface OrderDao extends JpaRepository<OrderEntity, Integer>{
//
//	List<OrderEntity> findByOrderId(int id);
//
//
//}
=======
package com.exploremore.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exploremore.entity.OrderEntity;



@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Integer> {
	List<OrderEntity> findById(int id);

	List<OrderEntity> findAll();


}
>>>>>>> development
