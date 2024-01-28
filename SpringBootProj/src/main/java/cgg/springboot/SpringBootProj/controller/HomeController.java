package cgg.springboot.SpringBootProj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String home() {
    System.out.println("This is home Handler");
    return "home";
  }

  @GetMapping("/about")
  public String about() {
    System.out.println("This is about Handler");
    return "about";
  }
}
