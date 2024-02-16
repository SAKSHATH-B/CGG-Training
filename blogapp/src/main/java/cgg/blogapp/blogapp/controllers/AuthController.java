package cgg.blogapp.blogapp.controllers;

import cgg.blogapp.blogapp.entities.RefreshToken;
import cgg.blogapp.blogapp.entities.User;
import cgg.blogapp.blogapp.payloads.UserDTO;
import cgg.blogapp.blogapp.security.JwtHelper;
import cgg.blogapp.blogapp.security.JwtRequest;
import cgg.blogapp.blogapp.security.JwtResponse;
import cgg.blogapp.blogapp.security.RefreshTokenRequest;
import cgg.blogapp.blogapp.services.CustomUserDetailsService;
import cgg.blogapp.blogapp.services.RefreshTokenService;
import cgg.blogapp.blogapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthController {

  @Autowired
  private UserService userService;

  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private JwtHelper jwtHelper;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private RefreshTokenService refreshTokenService;

  @PostMapping("/login")
  public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
    System.out.println(
      jwtRequest.getUsername() + " " + jwtRequest.getPassword()
    );
    boolean doAuthenticate = doAuthenticate(
      jwtRequest.getUsername(),
      jwtRequest.getPassword()
    );

    if (doAuthenticate) {
      UserDetails userDetails = customUserDetailsService.loadUserByUsername(
        jwtRequest.getUsername()
      );
      UserDTO user = modelMapper.map(userDetails, UserDTO.class);
      System.out.println(userDetails);

      String token = jwtHelper.generateToken(userDetails);

      RefreshToken refreshToken = refreshTokenService.createToken(
        jwtRequest.getUsername()
      );

      JwtResponse jwtResponse = JwtResponse
        .builder()
        .token(token)
        .user(user)
        .refreshToken(refreshToken.getRefreshToken())
        .build();

      return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    } else {
      throw new UsernameNotFoundException("User not found...");
    }
  }

  @PostMapping("/refresh")
  public JwtResponse refreshJwtToken(@RequestBody RefreshTokenRequest request) {
    RefreshToken refreshToken = refreshTokenService.verifyRefreshToken(
      request.getRefreshToken()
    );
    User user = refreshToken.getUser();
    UserDTO userDto = modelMapper.map(user, UserDTO.class);
    String token = jwtHelper.generateToken(user);
    return JwtResponse
      .builder()
      .refreshToken(refreshToken.getRefreshToken())
      .token(token)
      .user(userDto)
      .build();
  }

  private boolean doAuthenticate(String username, String password) {
    System.out.println(username);
    System.out.println("============");
    System.out.println(password);
    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
      username,
      password
    );
    try {
      manager.authenticate(authentication);
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException("Invalid Credentials...!");
    }
    return true;
  }

  @ExceptionHandler(BadCredentialsException.class)
  public String exceptionHandler(BadCredentialsException e) {
    return e.getMessage();
  }

  @PostMapping("/register")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    UserDTO userDto = modelMapper.map(user, UserDTO.class);
    UserDTO savedUser = userService.createUser(userDto);
    return ResponseEntity.ok(modelMapper.map(savedUser, User.class));
  }
}
