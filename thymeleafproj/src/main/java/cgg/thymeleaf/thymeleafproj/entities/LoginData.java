package cgg.thymeleaf.thymeleafproj.entities;

import cgg.thymeleaf.thymeleafproj.validations.ImageNameValid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginData {

  @NotBlank(message = "username cannot be empty!!")
  @Size(
    min = 3,
    max = 12,
    message = "username must be between 3 to 12 characters"
  )
  private String userName;

  @Email(
    regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",
    message = "Invalid email !!"
  )
  private String email;

  @AssertTrue(message = "must agree terms and conditions !!")
  private boolean agreed;

  @ImageNameValid
  private String imageName;
}
