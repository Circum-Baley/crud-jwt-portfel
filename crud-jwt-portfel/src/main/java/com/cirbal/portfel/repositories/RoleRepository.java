package com.cirbal.portfel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cirbal.portfel.enums.ERole;
import com.cirbal.portfel.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
