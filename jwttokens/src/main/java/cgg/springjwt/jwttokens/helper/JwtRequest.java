package cgg.springjwt.jwttokens.helper;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JwtRequest {

  private String email;
  private String password;
}
