package cgg.smartcontactmanager.smartcontactmanager.dao;

import cgg.smartcontactmanager.smartcontactmanager.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByName(String name);
}
