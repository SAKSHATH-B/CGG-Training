package cgg.blogapp.blogapp.services;

import cgg.blogapp.blogapp.dao.UserRepository;
import cgg.blogapp.blogapp.entities.User;
import cgg.blogapp.blogapp.exceptions.ResourceNotFoundException;
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
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    User user = userRepository
      .findByName(username)
      .orElseThrow(() ->
        new ResourceNotFoundException("user", "username " + username, 0)
      );
    return user;
  }
}
