package cgg.blogapp.blogapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int categoryId;

  @Column(name = "title", length = 100, nullable = false)
  private String categoryTitle;

  @Column(name = "description")
  private String categoryDescription;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Post> posts = new ArrayList<>();
}
