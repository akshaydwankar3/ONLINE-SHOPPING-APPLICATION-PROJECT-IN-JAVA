package com.masai.service;


import com.masai.exception.UserException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.User;
import com.masai.entity.UserLogin;
import com.masai.repository.UserDao;
import com.masai.repository.UserLoginDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao uDao;
	
	@Autowired
	private UserLoginDao lDao;
	
//	@Autowired
//	private PasswordEncoder encode;

	@Override
	public User addUser(User user) {
		User users = uDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	    if(users==null) {
	    	return uDao.save(user);
	    }
	    else {
	    	throw new UserException("User Existed..");
	    }
	}


	
	@Override
	public String loginUser(String username,String password) {
		
		User existUser=uDao.findByUsernameAndPassword(username, password);
		
		if(existUser==null) {
			throw new UserException("User not register..");
		}
		else {
			return "successfully login...";
		}
		
		
	}
	

	@Override
	public User removeUser(String username, String password) throws UserException {
		
		User existing=uDao.findByUsernameAndPassword(username, password);
		
		uDao.delete(existing);
		
		return existing;
	}

	@Override
	public User signOut(UserLogin userLogin) throws UserException {
		
		User existing=uDao.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());
		if(existing!=null) {
			 lDao.delete(userLogin);
			 return existing;
			
		}
		else {
			throw new UserException("User dose not exist...");
		}
		
	}



	@Override
	public List<User> getAllUser() throws UserException {
		List<User> user=uDao.findAll();
		if(user.size()>0) {
			return user;
		}
		else {
			throw new UserException("Any user dose not exist...");
		}
		
	}



	@Override
	public User updateUsername(String mobile, String newusername) throws UserException {
		
		User user= uDao.findByMobile(mobile);
		if(user!=null) {
			
			user.setUsername(newusername);
			
			return user;
		}
		else {
			throw new UserException("User dose not exist..");
		}
	}



	@Override
	public User updatePassword(String username, String newpassword) throws UserException {
		User user=uDao.findByUsername(username);
		if(user!=null) {
			user.setPassword(newpassword);
			return user;
		}
		else {
			throw new UserException("User dose not exist..");
		}
	}

	

	
	
}
