package com.cgg.OneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "employee_table")
@DynamicUpdate
public class Employee {

  //Identity
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employee_id")
  private int employeeId;

  @Column(name = "employee_name", length = 100, nullable = false)
  private String employeeName;

  @Column(name = "email")
  private String email;

  @Column(name = "date_of_joining")
  private Date doj;

  @Column(name = "salary")
  private double salary;

  @OneToOne(cascade = CascadeType.REMOVE)
  // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "address_id")
  private Address address;

  public Employee(
    int employeeId,
    String employeeName,
    String email,
    Date doj,
    double salary,
    Address address
  ) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.email = email;
    this.doj = doj;
    this.salary = salary;
    this.address = address;
  }

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDoj() {
    return doj;
  }

  public void setDoj(Date doj) {
    this.doj = doj;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
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
      "Employee [employeeId=" +
      employeeId +
      ", employeeName=" +
      employeeName +
      ", email=" +
      email +
      ", doj=" +
      doj +
      ", salary=" +
      salary +
      "]"
    );
  }
}
