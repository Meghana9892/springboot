package com.spring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	 User findByUsername(String username);
}
