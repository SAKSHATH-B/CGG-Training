package cgg.springboot.SpringBootProj.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @OneToMany(mappedBy = "department")
  private List<Employee> employees;

  public Department(long id, String name, List<Employee> employees) {
    this.id = id;
    this.name = name;
    this.employees = employees;
  }

  public Department() {}

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

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return (
      "Department [id=" +
      id +
      ", name=" +
      name +
      ", employees=" +
      employees +
      "]"
    );
  }
}
