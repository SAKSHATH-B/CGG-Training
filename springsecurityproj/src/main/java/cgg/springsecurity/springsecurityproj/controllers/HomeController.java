package cgg.springsecurity.springsecurityproj.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@EnableMethodSecurity
public class HomeController {

  @GetMapping("/home")
  @PreAuthorize("hasRole('NORMAL')")
  public String home() {
    return "This is home page";
  }

  @GetMapping("/login")
  @PreAuthorize("hasRole('NORMAL')")
  public String login() {
    return "This is Login page";
  }

  @GetMapping("/register")
  @PreAuthorize("hasRole('NORMAL')")
  public String register() {
    return "This is register page";
  }
}
