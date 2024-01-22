package cgg.springmvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user1")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private int userId;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  private String user_name;
  private String user_email;
  private String user_password;

  public User(String user_name, String user_email, String user_password) {
    this.user_name = user_name;
    this.user_email = user_email;
    this.user_password = user_password;
  }

  public User() {}

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getUser_email() {
    return user_email;
  }

  public void setUser_email(String user_email) {
    this.user_email = user_email;
  }

  public String getUser_password() {
    return user_password;
  }

  public void setUser_password(String user_password) {
    this.user_password = user_password;
  }

  @Override
  public String toString() {
    return (
      "User [userId=" +
      userId +
      ", user_name=" +
      user_name +
      ", user_email=" +
      user_email +
      ", user_password=" +
      user_password +
      "]"
    );
  }
}
