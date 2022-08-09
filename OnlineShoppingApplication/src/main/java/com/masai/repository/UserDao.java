package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	//public User findByConfirmPassword(String confirmPassword);
	
	public User findByUsernameAndPassword(String username, String password);
	public User findByMobile(String mobile);
	public User findByUsername(String username);
	
}
