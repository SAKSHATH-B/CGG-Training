package cgg.thymeleaf.thymeleafproj.controllers;

import cgg.thymeleaf.thymeleafproj.entities.LoginData;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomValidatorController {

  @PostMapping("/login")
  public ResponseEntity<LoginData> createUser(
    @Valid @RequestBody LoginData loginData
  ) {
    return ResponseEntity.ok(loginData);
  }
}
