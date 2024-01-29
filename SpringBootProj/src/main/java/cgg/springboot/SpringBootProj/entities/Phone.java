package cgg.springboot.SpringBootProj.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String number;

  @ManyToOne
  private Employee employee;

  public Phone(long id, String number, Employee employee) {
    this.id = id;
    this.number = number;
    this.employee = employee;
  }

  public Phone() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  @Override
  public String toString() {
    return (
      "Phone [id=" + id + ", number=" + number + ", employee=" + employee + "]"
    );
  }
}
