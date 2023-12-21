package com.cgg.hql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee_table")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employee_id")
  private int employeeId;

  @Column(name = "employee_name", length = 60, nullable = false)
  private String employeeName;

  @Column(name = "date_of_joining")
  private Date doj;

  @Column(name = "salary")
  private Double salary;

  @Column(name = "bonus")
  private BigDecimal bonus;

  @Column(name = "designation", length = 50)
  private String designation;

  @Column(name = "email", length = 50)
  private String email;

  public Employee() {}

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public Date getDoj() {
    return doj;
  }

  public void setDoj(Date doj) {
    this.doj = doj;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public BigDecimal getBonus() {
    return bonus;
  }

  public void setBonus(BigDecimal bonus) {
    this.bonus = bonus;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return (
      "Employee [employeeId=" +
      employeeId +
      ", employeeName=" +
      employeeName +
      ", doj=" +
      doj +
      ", salary=" +
      salary +
      ", bonus=" +
      bonus +
      ", designation=" +
      designation +
      ", email=" +
      email +
      "]"
    );
  }
}
