package cgg.hibernate.manytomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @Column(name = "emp_id")
  private int empId;

  private String name;

  @ManyToMany
  @JoinTable(
    name = "emp_proj",
    joinColumns = { @JoinColumn(name = "e_id") },
    inverseJoinColumns = { @JoinColumn(name = "p_id") }
  )
  private List<Project> projects;

  public Employee(int empId, String name, List<Project> projects) {
    this.empId = empId;
    this.name = name;
    this.projects = projects;
  }

  public Employee() {}

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return (
      "Employee [empId=" +
      empId +
      ", name=" +
      name +
      ", projects=" +
      projects +
      "]"
    );
  }
}
