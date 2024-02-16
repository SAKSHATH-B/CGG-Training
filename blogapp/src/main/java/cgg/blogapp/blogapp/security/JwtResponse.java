package cgg.blogapp.blogapp.security;

import cgg.blogapp.blogapp.payloads.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

  private String token;
  private UserDTO user;
  private String refreshToken;
}
