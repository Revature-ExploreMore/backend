package com.exploremore.dao;

<<<<<<< HEAD
<<<<<<< HEAD
public interface OrderDao {

=======
=======

>>>>>>> a6250c0c8632db463f6abbdf2b15456161e8ed5f
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exploremore.entity.OrderEntity;

public interface OrderDao extends JpaRepository<OrderEntity, Integer>{

	List<OrderEntity> findByOrderId(int id);
<<<<<<< HEAD
	
>>>>>>> Akshay
=======


>>>>>>> a6250c0c8632db463f6abbdf2b15456161e8ed5f
}
