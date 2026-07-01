package com.example.securityDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securityDemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	 User findByName(String name);
	
	
}
