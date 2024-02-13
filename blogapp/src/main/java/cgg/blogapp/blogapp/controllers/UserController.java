package cgg.blogapp.blogapp.controllers;

import cgg.blogapp.blogapp.payloads.UserDTO;
import cgg.blogapp.blogapp.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "scheme1")
@CrossOrigin("*")
public class UserController {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  //POST:create user
  @PostMapping("/")
  public ResponseEntity<UserDTO> createUser(
    @Valid @RequestBody UserDTO userDTO
  ) {
    userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    UserDTO createdUser = userService.createUser(userDTO);
    return new ResponseEntity<UserDTO>(createdUser, HttpStatus.CREATED);
  }

  //PUT:update user
  @PutMapping("/{userId}")
  public ResponseEntity<UserDTO> updateUser(
    @RequestBody UserDTO userDTO,
    @PathVariable("userId") int id
  ) {
    UserDTO updatedUser = userService.updateUser(id, userDTO);
    return ResponseEntity.ok(updatedUser);
  }

  //GET:single user
  @GetMapping("/{userId}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") int id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  //GET : all users
  @GetMapping("/")
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    List<UserDTO> allUsers = userService.getAllUsers();
    return new ResponseEntity<List<UserDTO>>(allUsers, HttpStatus.OK);
  }

  // @DeleteMapping("/{userId}")
  // public ResponseEntity<APIResponse> deleteUserById(
  //   @PathVariable("userId") int id
  // ) {
  //   userService.deleteUserById(id);
  //   return new ResponseEntity<APIResponse>(
  //     new APIResponse("user deleted successfully !!", true),
  //     HttpStatus.OK
  //   );
  // }
  @DeleteMapping("/{userId}")
  public ResponseEntity<ProblemDetail> deleteUserById(
    @PathVariable("userId") int id
  ) {
    userService.deleteUserById(id);
    return ResponseEntity
      .of(
        ProblemDetail.forStatusAndDetail(
          HttpStatus.OK,
          "User deleted successfully !!"
        )
      )
      .build();
  }
}
