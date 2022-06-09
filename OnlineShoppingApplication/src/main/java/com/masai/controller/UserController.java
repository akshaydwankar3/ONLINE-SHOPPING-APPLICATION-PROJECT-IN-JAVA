package com.masai.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.User;
import com.masai.entity.UserLogin;
import com.masai.repository.UserDao;
import com.masai.service.UserService;

@RestController
public class UserController {

  @Autowired
  UserDao uDao;

  @Autowired
  UserService uService;
  
  @PostMapping("/user/signup")
  public User addUserHandler(@RequestBody User user) {
    
    	return uService.addUser(user);

  }

  @GetMapping("/user")
  public ResponseEntity<List<User>> getAllUserDetails(){
	  List<User> user= uService.getAllUser();
	  return new ResponseEntity<List<User>>(user, HttpStatus.ACCEPTED);
  }
  
  @PostMapping("/user/login")
  public String loginUserHandler(@RequestBody UserLogin user) {
    return uService.loginUser(user.getUsername(), user.getPassword());
  }

  @DeleteMapping("user/logout")
  public ResponseEntity<User> signupUserHandler(@RequestBody UserLogin user) {
 
	  User users=uService.signOut(user);
	  
    return new ResponseEntity<User>(users, HttpStatus.OK);
  }

  @DeleteMapping("/user/remove")
  public ResponseEntity<User> removeUserHandler(User user) {
    
	  User existUser=uService.removeUser(user.getUsername(), user.getPassword());
	  
	 return new ResponseEntity<User>(existUser, HttpStatus.ACCEPTED);
  }
  
  @PutMapping("/getuser/{mobile}")
  public ResponseEntity<User> updateUserNameByMobile(@PathVariable("mobile") String mobile, @RequestParam("username") String newuser){
	  User user= uService.updateUsername(mobile, newuser);
	  return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
  }
  
  @PutMapping("/user/{username}/{mobile}")
  public ResponseEntity<User> updatePasswordByUser(@PathVariable("username") String username,@PathVariable("mobile") String mobile, @RequestParam("password") String newpassword){
	  User user= uService.updatePassword(username,mobile, newpassword);
	  return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
  }
  
  
}