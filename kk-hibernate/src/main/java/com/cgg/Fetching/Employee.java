package com.cgg.Fetching;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfile.FetchOverride;
import org.hibernate.annotations.FetchProfiles;
import org.hibernate.annotations.NaturalId;

//by using named entity graph
// @NamedEntityGraphs(
//   value = {
//     @NamedEntityGraph(
//       name = "employee.projects",
//       attributeNodes = @NamedAttributeNode("projects")
//     ),
//   }
// )
@Entity
@Table(name = "employee")
@FetchProfiles(
  value = {
    @FetchProfile(
      fetchOverrides = {
        @FetchOverride(
          association = "projects",
          entity = Employee.class,
          mode = FetchMode.JOIN
        ),
      },
      name = "employee.projects"
    ),
  }
)
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "employee_name", length = 60)
  private String employeeName;

  @NaturalId
  @Column(name = "user_name", length = 60, nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "access_level")
  private int accesslevel;

  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  @ManyToMany(mappedBy = "employees", cascade = CascadeType.PERSIST)
  private List<Project> projects = new ArrayList<>();

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getUserName() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccesslevel() {
    return accesslevel;
  }

  public void setAccesslevel(int accesslevel) {
    this.accesslevel = accesslevel;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return (
      "Employee [id=" +
      id +
      ", employeeName=" +
      employeeName +
      ", userName=" +
      username +
      ", password=" +
      password +
      ", accesslevel=" +
      accesslevel +
      ", department=" +
      department +
      "]"
    );
  }
}
