package cgg.blogapp.blogapp.payloads;

import cgg.blogapp.blogapp.entities.Category;
import cgg.blogapp.blogapp.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PostDTO {

  private int postId;
  private String title;
  private String content;
  private String imageName;
  private LocalDateTime addedDate;
  private Category category;

  @JsonIgnore
  private User user;

  public PostDTO() {
    this.addedDate = LocalDateTime.now();
  }
}
