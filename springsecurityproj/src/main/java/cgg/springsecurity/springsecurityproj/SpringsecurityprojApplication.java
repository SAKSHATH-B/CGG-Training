package cgg.springsecurity.springsecurityproj;

import cgg.springsecurity.springsecurityproj.dao.UserRepository;
import cgg.springsecurity.springsecurityproj.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringsecurityprojApplication implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(SpringsecurityprojApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User(
      "sakshath",
      bCryptPasswordEncoder.encode("sakshath"),
      "sakshath@gmail.com",
      "ROLE_NORMAL"
    );
    // userRepository.save(user1);
    User user2 = new User(
      "admin",
      bCryptPasswordEncoder.encode("admin"),
      "admin@gmail.com",
      "ROLE_ADMIN"
    );
    // userRepository.save(user2);
  }
}
