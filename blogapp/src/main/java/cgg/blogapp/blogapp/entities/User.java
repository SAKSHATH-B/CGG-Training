package cgg.blogapp.blogapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "user1")
@Data
public class User {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private int userId;

  @Column(name = "user_name", nullable = false, length = 100)
  private String name;

  @Column(name = "user_email")
  private String email;

  @Column(name = "user_password")
  private String password;

  @Column(name = "user_about")
  private String about;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Post> posts = new ArrayList<>();
}
