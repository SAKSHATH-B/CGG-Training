package cgg.blogapp.blogapp.dao;

import cgg.blogapp.blogapp.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByName(String name);
}
