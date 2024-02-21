package cgg.blogapp.blogapp.payloads;

import cgg.blogapp.blogapp.entities.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

  private int id;
  private String content;

  @JsonIgnore
  private Post post;
}
