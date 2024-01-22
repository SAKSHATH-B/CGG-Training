package cgg.spring.ormvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

  @Id
  private int userId;

  private String userName;
  private String about;

  public User(int userId, String userName, String about) {
    this.userId = userId;
    this.userName = userName;
    this.about = about;
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

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  @Override
  public String toString() {
    return (
      "User [userId=" +
      userId +
      ", userName=" +
      userName +
      ", about=" +
      about +
      "]"
    );
  }
}
