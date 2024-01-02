package cgg.tech.blog.dao;

import cgg.tech.blog.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {

  private Connection conn;

  public UserDao(Connection conn) {
    this.conn = conn;
  }

  public Boolean saveUser(User user) {
    boolean f = false;
    try {
      String query =
        "insert into \"user\" (name,password,email,gender,about) values (?,?,?,?,?)";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, user.getName());
      ps.setString(2, user.getPassword());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getGender());
      ps.setString(5, user.getAbout());
      ps.executeUpdate();
      f = true;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return f;
  }
}
