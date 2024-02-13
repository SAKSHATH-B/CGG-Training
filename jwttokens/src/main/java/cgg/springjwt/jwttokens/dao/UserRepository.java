package cgg.springjwt.jwttokens.dao;

import cgg.springjwt.jwttokens.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);
}
