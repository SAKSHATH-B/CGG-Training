package cgg.springboot.SpringBootProj.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private int age;

  @OneToMany(mappedBy = "employee")
  private List<Phone> phones;

  @ManyToOne
  private Department department;

  public Employee(
    long id,
    String name,
    int age,
    List<Phone> phones,
    Department department
  ) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.phones = phones;
    this.department = department;
  }

  public Employee() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
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
      "Employee [id=" +
      id +
      ", name=" +
      name +
      ", age=" +
      age +
      ", phones=" +
      phones +
      ", department=" +
      department +
      "]"
    );
  }
}
