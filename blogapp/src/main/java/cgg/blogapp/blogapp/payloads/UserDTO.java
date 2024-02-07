package cgg.blogapp.blogapp.payloads;

import cgg.blogapp.blogapp.entities.Post;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

@Data
public class UserDTO {

  private int userId;

  @NotEmpty
  @Size(min = 4, message = "username must be min of 4 characters")
  private String name;

  @Email(message = "Email address is not valid")
  @NotEmpty(message = "Email required!")
  private String email;

  @NotEmpty
  @Size(
    min = 3,
    max = 10,
    message = "password must be min of 3 chars and max of 10 chars"
  )
  private String password;

  @NotEmpty
  private String about;

  private List<Post> posts;
}
