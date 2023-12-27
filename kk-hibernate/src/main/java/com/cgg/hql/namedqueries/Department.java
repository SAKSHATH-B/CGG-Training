package com.cgg.hql.namedqueries;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department_table")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dept_id")
  private Integer departmentId;

  @Column(name = "dept_name")
  private String departmentName;

  @Column(name = "dept_location")
  private String departmentLocation;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
  private Set<Employee> employees = new HashSet<Employee>();

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDepartmentLocation() {
    return departmentLocation;
  }

  public void setDepartmentLocation(String departmentLocation) {
    this.departmentLocation = departmentLocation;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

  public Set<Employee> getEmployees() {
    return employees;
  }
}
