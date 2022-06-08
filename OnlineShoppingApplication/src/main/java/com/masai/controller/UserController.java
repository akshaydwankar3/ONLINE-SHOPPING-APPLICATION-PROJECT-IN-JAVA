package com.masai.controller;

import com.masai.model.Session;
import com.masai.model.User;
import com.masai.repository.UserDao;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserDao uDao;

  @PostMapping("/user/signup")
  public Session addUserHandler(@Valid @RequestBody User user) {
    List<User> users = uDao.findAll();
    System.out.println("User:" + " " + user.toString());
    for (User e : users) {
      System.out.println("User signup:" + " " + user.toString());

      if (e.equals(user)) {
        System.out.println("Already register..");
        return Session.EXISTS;
      }
    }

    uDao.save(user);

    return Session.SUCCESS;
  }

  @PostMapping("/user/login")
  public Session loUserHandler(@Valid @RequestBody User user) {
    List<User> userExists = uDao.findAll();

    for (User e : userExists) {
      if (e.equals(user)) {
        user.setSignup(true);
        uDao.save(user);
        return Session.SUCCESS;
      }
    }

    return Session.FAILLURE;
  }

  @PostMapping("user/logout")
  public Session signupUserHandler(@Valid @RequestBody User user) {
    List<User> userExists = uDao.findAll();

    for (User e : userExists) {
      if (e.equals(user)) {
        e.setSignup(false);
        uDao.save(user);
        return Session.SUCCESS;
      }
    }

    return Session.FAILLURE;
  }

  @DeleteMapping("/user/removeall")
  public Session deleteAllUserHandler() {
    uDao.deleteAll();
    return Session.SUCCESS;
  }

  @DeleteMapping("/user/remove")
  public Session removeUserHandler(User user) {
    List<User> userExists = uDao.findAll();
    for (User e : userExists) {
      e.setSignup(true);
      uDao.delete(user);
      return Session.SUCCESS;
    }
    return Session.FAILLURE;
  }
}
