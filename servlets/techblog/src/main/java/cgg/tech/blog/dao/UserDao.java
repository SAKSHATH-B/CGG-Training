package cgg.tech.blog.dao;

import cgg.tech.blog.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

  private Connection conn;

  public UserDao(Connection conn) {
    this.conn = conn;
  }

  public Boolean saveUser(User user) {
    boolean f = false;
    try {
      String query =
        "insert into user1 (name,password,email,gender,about) values (?,?,?,?,?)";
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

  //fetch user based on email and password
  public User getUserByEmailAndPassword(String email, String password) {
    User user = null;
    String query = "select * from user1 where email=? and password=?";
    try {
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        user = new User();
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setGender(rs.getString("gender"));
        user.setAbout(rs.getString("about"));
        user.setId(rs.getInt("id"));
        user.setProfile(rs.getString("profile"));
        user.setRdate(rs.getTimestamp("rdate"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return user;
  }

  public boolean updateUser(User user) {
    boolean f = false;
    try {
      String query =
        "update user1 set name=?,email=?,password=?,gender=?,about=?,profile=? where id=?";
      PreparedStatement p = conn.prepareStatement(query);
      p.setString(1, user.getName());
      p.setString(2, user.getEmail());
      p.setString(3, user.getPassword());
      p.setString(4, user.getGender());
      p.setString(5, user.getAbout());
      p.setString(6, user.getProfile());
      p.setInt(7, user.getId());
      p.executeUpdate();
      f = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return f;
  }

  public User getUserByUserId(int userId) {
    User user = null;
    try {
      PreparedStatement ps = conn.prepareStatement(
        "select * from user1 where id=" + userId
      );
      // ps.setInt(1, userId);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        user = new User();
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setGender(rs.getString("gender"));
        user.setAbout(rs.getString("about"));
        user.setId(rs.getInt("id"));
        user.setProfile(rs.getString("profile"));
        user.setRdate(rs.getTimestamp("rdate"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }
}
