package cgg.springsecurity.springsecurityproj.dao;

import cgg.springsecurity.springsecurityproj.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
  User findByUsername(String username);
}
