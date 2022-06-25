package com.exploremore.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exploremore.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
	
	List<UserEntity> findByUsernameAndPassword(String username, String password);

}
