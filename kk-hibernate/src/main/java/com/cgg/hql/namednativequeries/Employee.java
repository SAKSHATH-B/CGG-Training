package com.cgg.hql.namednativequeries;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "employee_table")
@NamedNativeQueries(
  value = {
    @NamedNativeQuery(
      name = "getTotalSalbyDept",
      query = "select dept.dept_name as dept_name,sum(emp.salary) as TotalSalary from department_table dept left join employee_table emp on dept.dept_id=emp.dept_id group by dept.dept_id having sum(emp.salary)>200000"
    ),
    @NamedNativeQuery(
      name = "Employee.byId",
      query = "select * from employee_table where employee_id=:empId",
      resultClass = Employee.class
    ),
  }
)
public class Employee {

  @Id
  @Column(name = "employee_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer employeeId;

  @Column(name = "employee_name", length = 60, nullable = false)
  private String employeeName;

  @Column(name = "date_of_joining")
  private String doj;

  @Column(name = "salary")
  private Double salary;

  @Column(name = "bonus")
  private BigDecimal bonus;

  @Column(name = "designation", length = 50)
  private String designation;

  @Column(name = "email", length = 50)
  private String email;

  @ManyToOne
  @JoinColumn(name = "dept_id")
  private Department department;

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getDoj() {
    return doj;
  }

  public void setDoj(String doj) {
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

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
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
      ", department=" +
      department +
      "]"
    );
  }
}
