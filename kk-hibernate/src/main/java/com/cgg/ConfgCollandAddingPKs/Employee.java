package com.cgg.ConfgCollandAddingPKs;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "employee_table")
@DynamicUpdate
public class Employee {

  //Auto
  // @Id
  // @GeneratedValue(strategy = GenerationType.AUTO, generator = "empid_generator")
  // @SequenceGenerator(
  //   name = "empid_generator",
  //   initialValue = 1,
  //   allocationSize = 1,
  //   sequenceName = "empid_seq"
  // )
  // @Column(name = "employee_id")
  // private int employeeId;

  //Identity
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employee_id")
  private int employeeId;

  //Sequence
  // @Id
  // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
  // @SequenceGenerator(
  //   name = "seq_gen",
  //   sequenceName = "seq",
  //   initialValue = 1,
  //   allocationSize = 1
  // )
  // @Column(name = "employee_id")
  // private int employeeId;

  //Table
  // @Id
  // @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab_seq_gen")
  // @TableGenerator(
  //   name = "tab_seq_gen",
  //   table = "tab_seq_gen",
  //   initialValue = 1,
  //   allocationSize = 1
  // )
  // @Column(name = "employee_id")
  // private int employeeId;

  @Column(name = "employee_name", length = 100, nullable = false)
  private String employeeName;

  @Column(name = "email")
  private String email;

  @Column(name = "date_of_joining")
  private Date doj;

  @Column(name = "salary")
  private double salary;

  @ElementCollection
  @JoinTable(
    name = "address_table",
    joinColumns = @JoinColumn(name = "employee_id")
  )
  private Collection<Address> addressList = new ArrayList();

  @Embedded
  @AttributeOverrides(
    value = {
      @AttributeOverride(
        column = @Column(name = "home_street_name", length = 50),
        name = "street"
      ),
      @AttributeOverride(
        column = @Column(name = "home_state_name"),
        name = "state"
      ),
      @AttributeOverride(
        column = @Column(name = "home_city_name"),
        name = "city"
      ),
      @AttributeOverride(
        column = @Column(name = "home_pin_code"),
        name = "pincode"
      ),
    }
  )
  private Address homeAddress;

  @Embedded
  @AttributeOverrides(
    value = {
      @AttributeOverride(
        column = @Column(name = "office_street_name", length = 50),
        name = "street"
      ),
      @AttributeOverride(
        column = @Column(name = "office_state_name"),
        name = "state"
      ),
      @AttributeOverride(
        column = @Column(name = "office_city_name"),
        name = "city"
      ),
      @AttributeOverride(
        column = @Column(name = "office_pin_code"),
        name = "pincode"
      ),
    }
  )
  private Address officeAddress;

  public Employee(
    int employeeId,
    String employeeName,
    String email,
    Date doj,
    double salary,
    Collection<Address> addressList,
    Address homeAddress,
    Address officeAddress
  ) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.email = email;
    this.doj = doj;
    this.salary = salary;
    this.addressList = addressList;
    this.homeAddress = homeAddress;
    this.officeAddress = officeAddress;
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

  public Address getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }

  public Address getOfficeAddress() {
    return officeAddress;
  }

  public void setOfficeAddress(Address officeAddress) {
    this.officeAddress = officeAddress;
  }

  public Collection<Address> getAddressList() {
    return addressList;
  }

  public void setAddressList(Collection<Address> addressList) {
    this.addressList = addressList;
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
      ", addressList=" +
      addressList +
      ", homeAddress=" +
      homeAddress +
      ", officeAddress=" +
      officeAddress +
      "]"
    );
  }
}
