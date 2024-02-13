package cgg.springjwt.jwttokens.services;

import cgg.springjwt.jwttokens.dao.UserRepository;
import cgg.springjwt.jwttokens.entities.User;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  BCryptPasswordEncoder passwordEncoder;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User createUser(User user) {
    user.setUserId(UUID.randomUUID().toString());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }
}
