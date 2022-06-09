package com.masai.service;





import java.util.List;

import com.masai.entity.User;
import com.masai.entity.UserLogin;
import com.masai.exception.UserException;

public interface UserService {

	public User addUser(User user);
	
	public String loginUser(String username,String password) throws UserException;

	public User removeUser(String username, String password) throws UserException;

	public User signOut(UserLogin user) throws UserException;
	
	public List<User> getAllUser()throws UserException;
	
	public User updateUsername(String mobile,String newusername) throws UserException;
		
	
	public User updatePassword(String username, String newpassword) throws UserException;
	
	
	
	
}
