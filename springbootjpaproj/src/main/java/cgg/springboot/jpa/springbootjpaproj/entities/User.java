package cgg.springboot.jpa.springbootjpaproj.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user1")
@Data
public class User {

  @Id
  @GeneratedValue
  private int id;

  private String name;
  private String city;
  private String status;
}
