package com.stackroute.keepnote.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user1")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userId;

  private String userName;
  private String userPassword;
  private String userMobile;
  private final LocalDateTime userAddedDate = LocalDateTime.now();

  public User(
    int userId,
    String userName,
    String userPassword,
    String userMobile
  ) {
    this.userId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
    this.userMobile = userMobile;
  }

  public User() {}

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserMobile() {
    return userMobile;
  }

  public void setUserMobile(String userMobile) {
    this.userMobile = userMobile;
  }

  public LocalDateTime getUserAddedDate() {
    return userAddedDate;
  }

  @Override
  public String toString() {
    return (
      "User [userId=" +
      userId +
      ", userName=" +
      userName +
      ", userPassword=" +
      userPassword +
      ", userMobile=" +
      userMobile +
      ", userAddedDate=" +
      userAddedDate +
      "]"
    );
  }
}
