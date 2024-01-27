package cgg.springmvc.entities;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public class Student {

  private Long id;
  private String name;

  // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  // @DateTimeFormat(pattern = "dd**MM**yyyy")
  private Date dob;

  private List<String> courses;
  private String gender;
  private String type;
  private Address address;

  public Student(
    Long id,
    String name,
    Date dob,
    List<String> courses,
    String gender,
    String type,
    Address address
  ) {
    this.id = id;
    this.name = name;
    this.dob = dob;
    this.courses = courses;
    this.gender = gender;
    this.type = type;
    this.address = address;
  }

  public Student() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getCourses() {
    return courses;
  }

  public void setCourses(List<String> courses) {
    this.courses = courses;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return (
      "Student [id=" +
      id +
      ", name=" +
      name +
      ", dob=" +
      dob +
      ", courses=" +
      courses +
      ", gender=" +
      gender +
      ", type=" +
      type +
      ", address=" +
      address +
      "]"
    );
  }
}
