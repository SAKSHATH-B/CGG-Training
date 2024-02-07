package cgg.blogapp.blogapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int postId;

  @Column(name = "post_title", length = 100, nullable = false)
  private String title;

  @Column(length = 10000)
  private String content;

  private String imageName;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime addedDate;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne(cascade = CascadeType.ALL)
  private User user;
}
