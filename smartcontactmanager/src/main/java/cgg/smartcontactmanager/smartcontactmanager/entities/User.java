package cgg.smartcontactmanager.smartcontactmanager.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @NotBlank(message = "Name is required !!")
  @Size(
    min = 2,
    max = 20,
    message = "min 2 and max 20 characters are allowed!!"
  )
  private String name;

  @Column(unique = true)
  private String email;

  private String password;
  private String role;
  private boolean enabled;
  private String imageUrl;
  private String about;

  @OneToMany(
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "user"
  )
  private List<Contact> contacts = new ArrayList<>();
}
