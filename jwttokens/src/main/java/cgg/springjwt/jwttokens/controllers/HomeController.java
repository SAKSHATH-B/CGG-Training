package cgg.springjwt.jwttokens.controllers;

import cgg.springjwt.jwttokens.entities.User;
import cgg.springjwt.jwttokens.services.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  Logger logger = LoggerFactory.getLogger(HomeController.class);

  @Autowired
  UserService userService;

  @GetMapping("/test")
  public String test() {
    logger.warn("This is working message");
    return "This is testing message..";
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUsers() {
    List<User> users = userService.getUsers();
    return ResponseEntity.ok(users);
  }
}
