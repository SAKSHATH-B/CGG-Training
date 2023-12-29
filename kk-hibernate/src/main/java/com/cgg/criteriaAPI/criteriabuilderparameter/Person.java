package com.cgg.criteriaAPI.criteriabuilderparameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import java.util.Date;

@Entity
@Table(name = "Person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "nickName")
  private String nickName;

  @Column(name = "address")
  private String address;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "createdOn")
  private Date createdOn;

  @Version
  @Column(name = "version")
  private int version;

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

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return (
      "Person [id=" +
      id +
      ", name=" +
      name +
      ", nickName=" +
      nickName +
      ", address=" +
      address +
      ", createdOn=" +
      createdOn +
      ", version=" +
      version +
      "]"
    );
  }
}
