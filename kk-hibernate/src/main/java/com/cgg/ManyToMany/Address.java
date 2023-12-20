package com.cgg.ManyToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

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

  @ManyToMany(mappedBy = "addressList")
  private Collection<Employee> empList = new ArrayList<>();

  public Address(
    int addressId,
    String street,
    String city,
    String state,
    Long pincode,
    Collection<Employee> empList
  ) {
    this.addressId = addressId;
    this.street = street;
    this.city = city;
    this.state = state;
    this.pincode = pincode;
    this.empList = empList;
  }

  public Collection<Employee> getEmpList() {
    return empList;
  }

  public void setEmpList(Collection<Employee> empList) {
    this.empList = empList;
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
      ", empList=" +
      empList +
      "]"
    );
  }
}
