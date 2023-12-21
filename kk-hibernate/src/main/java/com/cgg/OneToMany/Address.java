package com.cgg.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address-table")
public class Address {

  @Id
  @Column(name = "address_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int addressId;

  @Column(name = "street_name", length = 50)
  private String street;

  @Column(name = "city_name", length = 50)
  private String city;

  @Column(name = "state_name")
  private String state;

  @Column(name = "pin_code")
  private Long pincode;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  public Address(
    int addressId,
    String street,
    String city,
    String state,
    Long pincode,
    Employee employee
  ) {
    this.addressId = addressId;
    this.street = street;
    this.city = city;
    this.state = state;
    this.pincode = pincode;
    this.employee = employee;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Address() {}

  public int getAddressId() {
    return addressId;
  }

  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Long getPincode() {
    return pincode;
  }

  public void setPincode(Long pincode) {
    this.pincode = pincode;
  }

  @Override
  public String toString() {
    return (
      "Address [addressId=" +
      addressId +
      ", street=" +
      street +
      ", city=" +
      city +
      ", state=" +
      state +
      ", pincode=" +
      pincode +
      "]"
    );
  }
}
