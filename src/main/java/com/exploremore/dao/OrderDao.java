package com.exploremore.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exploremore.entity.OrderEntity;
import com.exploremore.entity.OrderEntity;
@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Integer>{
	List<OrderEntity> findById(int id);
	List<OrderEntity> findAll();
}
