package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.UserLogin;

@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, Integer> {
	

}
