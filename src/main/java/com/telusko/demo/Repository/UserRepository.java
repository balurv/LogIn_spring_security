package com.telusko.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
