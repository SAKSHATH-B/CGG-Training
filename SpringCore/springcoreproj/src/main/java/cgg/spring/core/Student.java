package cgg.spring.core;

public class Student {

  private int studentId;
  private String studentName;
  private String email;
  private String gender;

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return (
      "Student [studentId=" +
      studentId +
      ", studentName=" +
      studentName +
      ", email=" +
      email +
      ", gender=" +
      gender +
      "]"
    );
  }
}
