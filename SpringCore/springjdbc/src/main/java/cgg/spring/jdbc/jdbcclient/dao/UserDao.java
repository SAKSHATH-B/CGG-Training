package cgg.spring.jdbc.jdbcclient.dao;

import cgg.spring.jdbc.jdbcclient.entities.User;
import java.util.List;

public interface UserDao {
  User createUser(User user);
  User updateUser(User user);
  int deleteUser(int id);
  User getUserById(int id);
  List<User> getAllUsers();
}
