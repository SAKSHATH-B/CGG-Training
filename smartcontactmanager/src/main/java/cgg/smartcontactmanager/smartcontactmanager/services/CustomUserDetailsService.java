package cgg.smartcontactmanager.smartcontactmanager.services;

import cgg.smartcontactmanager.smartcontactmanager.dao.UserRepository;
import cgg.smartcontactmanager.smartcontactmanager.entities.CustomUserDetails;
import cgg.smartcontactmanager.smartcontactmanager.entities.User;
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
    User user = userRepository.findByName(username);
    if (user == null) {
      throw new UsernameNotFoundException("No User Found...");
    }
    return new CustomUserDetails(user);
  }
}
