package cgg.thymeleaf.thymeleafproj.dao;

import cgg.thymeleaf.thymeleafproj.entities.User;

public interface UserDao {
  public int createTable();

  public int createUser(User user);
}
