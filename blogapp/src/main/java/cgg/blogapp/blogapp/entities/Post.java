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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
  @JsonIgnore
  private Category category;

  @ManyToOne(cascade = CascadeType.ALL)
  @JsonIgnore
  private User user;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Comment> comments = new HashSet<>();

  @Override
  public String toString() {
    return (
      "Post [postId=" +
      postId +
      ", title=" +
      title +
      ", content=" +
      content +
      ", imageName=" +
      imageName +
      ", addedDate=" +
      addedDate +
      "]"
    );
  }
}
