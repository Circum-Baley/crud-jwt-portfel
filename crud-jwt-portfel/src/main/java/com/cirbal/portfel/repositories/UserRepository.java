package com.cirbal.portfel.repositories;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cirbal.portfel.model.UserDAO;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Integer> {
	
	UserDAO findByUsername(String username);
	
}