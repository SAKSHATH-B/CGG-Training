package cgg.blogapp.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/signin")
  public String customLogin() {
    System.out.println("This is login page....");
    return "login";
  }

  @GetMapping("/home")
  public String home() {
    return "homepage";
  }

  @GetMapping("/logout")
  public String customlogout() {
    return "logout";
  }
}
