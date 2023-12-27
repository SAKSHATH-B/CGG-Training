package cgg.hibernate;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@NamedQuery(name = "Student.byId", query = "from Student where id=:x")
@NamedNativeQuery(
  name = "Student.byName",
  query = "select * from Student where name=:y",
  resultClass = Student.class
)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {

  @Id
  private int id;

  private String name;
  private String city;

  private Certificate certi;

  public Student(int id, String name, String city, Certificate certi) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.certi = certi;
  }

  public Certificate getCerti() {
    return certi;
  }

  public void setCerti(Certificate certi) {
    this.certi = certi;
  }

  public Student() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return (
      "Student [id=" +
      id +
      ", name=" +
      name +
      ", city=" +
      city +
      ", certi=" +
      certi +
      "]"
    );
  }
}
