package com.stackroute.keepnote.controller;

import com.stackroute.keepnote.exceptions.UserNotFoundException;
import com.stackroute.keepnote.model.User;
import com.stackroute.keepnote.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user/register")
  public ResponseEntity<String> registerUser(@RequestBody User user) {
    try {
      boolean registerUser = userService.registerUser(user);
      return new ResponseEntity<String>(
        "User created status" + registerUser,
        HttpStatus.CREATED
      );
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<String> getUser(
    @PathVariable("id") int id,
    HttpSession session
  ) {
    User user = (User) session.getAttribute("user");
    if (user == null) {
      return new ResponseEntity<>(
        "User not logged in..",
        HttpStatus.UNAUTHORIZED
      );
    }
    try {
      User userById = userService.getUserById(id);
      // System.out.println(userById);
      return new ResponseEntity<String>(
        "User found with id " + id + " " + userById,
        HttpStatus.OK
      );
    } catch (UserNotFoundException e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<String> updateUser(
    @PathVariable("id") int id,
    @RequestBody User user,
    HttpSession session
  ) {
    User user1 = (User) session.getAttribute("user");
    if (user1 == null) {
      return new ResponseEntity<>(
        "User not logged in..",
        HttpStatus.UNAUTHORIZED
      );
    }
    try {
      userService.updateUser(user, id);
      return new ResponseEntity<String>("User Updated...", HttpStatus.OK);
    } catch (UserNotFoundException e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity<String> deleteUser(
    @PathVariable("id") int id,
    HttpSession session
  ) {
    User user = (User) session.getAttribute("user");
    if (user == null) {
      return new ResponseEntity<>(
        "User not logged in..",
        HttpStatus.UNAUTHORIZED
      );
    }
    try {
      userService.getUserById(id);
      userService.deleteUser(id);
      return new ResponseEntity<String>("User Deleted...", HttpStatus.OK);
    } catch (UserNotFoundException e) {
      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
  }
}
