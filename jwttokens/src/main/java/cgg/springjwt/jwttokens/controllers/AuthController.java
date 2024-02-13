package cgg.springjwt.jwttokens.controllers;

import cgg.springjwt.jwttokens.entities.RefreshToken;
import cgg.springjwt.jwttokens.entities.User;
import cgg.springjwt.jwttokens.helper.JwtHelper;
import cgg.springjwt.jwttokens.helper.JwtRequest;
import cgg.springjwt.jwttokens.helper.JwtResponse;
import cgg.springjwt.jwttokens.helper.RefreshTokenRequest;
import cgg.springjwt.jwttokens.services.CustomUserDetailsService;
import cgg.springjwt.jwttokens.services.RefreshTokenService;
import cgg.springjwt.jwttokens.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private JwtHelper helper;

  @Autowired
  private UserService userService;

  @Autowired
  private RefreshTokenService refreshTokenService;

  private Logger logger = LoggerFactory.getLogger(AuthController.class);

  @PostMapping("/login")
  public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
    System.out.println(request.getEmail());
    doAuthenticate(request.getEmail(), request.getPassword());

    User userDetails = userDetailsService.loadUserByUsername(
      request.getEmail()
    );
    System.out.println(userDetails);
    String token = helper.generateToken(userDetails);

    RefreshToken refreshToken = refreshTokenService.createRefreshToken(
      userDetails.getEmail()
    );

    JwtResponse jwtResponse = JwtResponse
      .builder()
      .token(token)
      .username(userDetails.getEmail())
      .refreshToken(refreshToken.getRefreshToken())
      .build();

    return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
  }

  private void doAuthenticate(String username, String password) {
    System.out.println(username);
    System.out.println(password);
    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
      username,
      password
    );
    try {
      manager.authenticate(authentication);
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException("Invalid Username and password !!");
    }
  }

  @ExceptionHandler(BadCredentialsException.class)
  public String exceptionHandler(BadCredentialsException e) {
    return e.getMessage();
  }

  @PostMapping("/createuser")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User u = userService.createUser(user);
    return ResponseEntity.ok(u);
  }

  @PostMapping("/refresh")
  public JwtResponse refreshJwtToken(@RequestBody RefreshTokenRequest request) {
    RefreshToken refreshToken = refreshTokenService.verifyRequestToken(
      request.getRefreshToken()
    );
    User user = refreshToken.getUser();
    String token = helper.generateToken(user);
    return JwtResponse
      .builder()
      .refreshToken(refreshToken.getRefreshToken())
      .token(token)
      .username(user.getEmail())
      .build();
  }
}
