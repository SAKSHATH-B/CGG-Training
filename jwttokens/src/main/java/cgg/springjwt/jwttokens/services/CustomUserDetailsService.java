package cgg.springjwt.jwttokens.services;

import cgg.springjwt.jwttokens.dao.UserRepository;
import cgg.springjwt.jwttokens.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User loadUserByUsername(String username)
    throws UsernameNotFoundException {
    System.out.println(username + "------------");
    User user = userRepository
      .findByEmail(username)
      .orElseThrow(() -> new UsernameNotFoundException("No User Found"));

    return user;
  }
}
