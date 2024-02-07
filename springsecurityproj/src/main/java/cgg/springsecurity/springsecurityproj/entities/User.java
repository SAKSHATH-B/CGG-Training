package cgg.springsecurity.springsecurityproj.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user1")
public class User {

  @Id
  private String username;

  private String password;
  private String email;
  private String role;
}
