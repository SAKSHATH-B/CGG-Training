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

  //fetch user based on username and password
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
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return user;
  }
}
