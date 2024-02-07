package cgg.springsecurity.springsecurityproj.controllers;

import cgg.springsecurity.springsecurityproj.dao.UserRepository;
import cgg.springsecurity.springsecurityproj.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  static {
    // users.add(new User("sakshath", "123456Sak", "sakshath@gmail.com"));
    // users.add(new User("madhav", "hello123", "madhav@gmail.com"));
    // users.add(new User("ajay", "kukat456", "ajay@gmail.com"));
    // users.add(new User("arvind", "gade178", "arvind@gmail.com"));
  }

  @GetMapping("/")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(userRepository.findAll());
  }

  @GetMapping("/{name}")
  public ResponseEntity<User> getUserByName(@PathVariable String name) {
    // User u = users
    //   .stream()
    //   .filter(user -> user.getUsername().equals(name))
    //   .findAny()
    //   .orElse(null);
    return ResponseEntity.ok(userRepository.findByUsername(name));
  }

  @PostMapping("/")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    // users.add(user);
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
  }
}
