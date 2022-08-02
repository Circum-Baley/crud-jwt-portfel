package com.cirbal.portfel.repositories;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cirbal.portfel.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
//
//import com.cirbal.portfel.model.UserDAO;
//
//@Repository
//public interface UserRepository extends CrudRepository<User, Integer> {
//	
//	UserDAO findByUsername(String username);
//	
//}