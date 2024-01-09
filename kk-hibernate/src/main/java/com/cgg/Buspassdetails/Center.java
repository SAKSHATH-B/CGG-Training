package com.cgg.Buspassdetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "center")
public class Center {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "center_id")
  private Long centerId;

  @Column(name = "date")
  private Date date;

  @OneToMany(mappedBy = "centerId", cascade = CascadeType.ALL)
  private List<PassDetails> passDetails = new ArrayList<>();

  @Column(name = "capacity")
  private Integer capacity;

  @Column(name = "registered_students")
  private Integer registeredStudents;

  @Column(name = "status", length = 20)
  private String status;

  @Column(name = "inserted_time")
  private Date insertedTime;

  @Column(name = "passid")
  private Integer passId;

  @Column(name = "map_id")
  private Integer mapId;

  public Center() {}

  public Center(
    Long centerId,
    Date date,
    List<PassDetails> passDetails,
    Integer capacity,
    Integer registeredStudents,
    String status,
    Date insertedTime,
    Integer passId,
    Integer mapId
  ) {
    this.centerId = centerId;
    this.date = date;
    this.passDetails = passDetails;
    this.capacity = capacity;
    this.registeredStudents = registeredStudents;
    this.status = status;
    this.insertedTime = insertedTime;
    this.passId = passId;
    this.mapId = mapId;
  }

  public Long getCenterId() {
    return centerId;
  }

  public void setCenterId(Long centerId) {
    this.centerId = centerId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public List<PassDetails> getPassDetails() {
    return passDetails;
  }

  public void setPassDetails(List<PassDetails> passDetails) {
    this.passDetails = passDetails;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Integer getRegisteredStudents() {
    return registeredStudents;
  }

  public void setRegisteredStudents(Integer registeredStudents) {
    this.registeredStudents = registeredStudents;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getInsertedTime() {
    return insertedTime;
  }

  public void setInsertedTime(Date insertedTime) {
    this.insertedTime = insertedTime;
  }

  public Integer getPassId() {
    return passId;
  }

  public void setPassId(Integer passId) {
    this.passId = passId;
  }

  public Integer getMapId() {
    return mapId;
  }

  public void setMapId(Integer mapId) {
    this.mapId = mapId;
  }
}
