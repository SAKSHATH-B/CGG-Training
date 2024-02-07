package cgg.thymeleaf.thymeleafproj.controllers;

import cgg.thymeleaf.thymeleafproj.entities.LoginData;
import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

  @GetMapping("/about")
  public String about(Model m) {
    m.addAttribute("name", "cgg");
    m.addAttribute("date", new Date());
    System.out.println("This is about handler..");
    return "about";
  }

  @GetMapping("/iterate")
  public String iterateHandler(Model m) {
    List<String> list = List.of("CGG", "TechM", "Qualcomm", "Coforge");
    m.addAttribute("companies", list);
    System.out.println("Iterate handler...");
    return "iterate";
  }

  @GetMapping("/conditional")
  public String conditionalHandler(Model m) {
    System.out.println("Conditional Handler");
    m.addAttribute("gender", "F");
    m.addAttribute("isActive", true);
    // List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
    // List<Integer> list = List.of(1);
    List<Integer> list = List.of();
    m.addAttribute("mylist", list);
    return "conditional";
  }

  //handler for including fragments
  @GetMapping("/service")
  public String service(Model m) {
    //passing dynamic content to hostTag and to fragment
    m.addAttribute("title", "Mahesh Babu");
    m.addAttribute("subtitle", "GMB");
    //processing logic
    return "service";
  }

  @GetMapping("/contact")
  public String contactHandler() {
    return "contact";
  }

  @GetMapping("/newabout")
  public String newAbout() {
    return "newabout";
  }

  //Form
  @GetMapping("/form")
  public String openForm(Model m) {
    System.out.println("Opening form");
    m.addAttribute("loginData", new LoginData());
    return "form";
  }

  @PostMapping("/process")
  public String handleForm(
    @Valid @ModelAttribute LoginData loginData,
    BindingResult result
  ) {
    //process the data
    if (result.hasErrors()) {
      System.out.println(result);
      return "form";
    }
    System.out.println(loginData);
    return "success";
  }

  @RequestMapping("/example")
  public String example() {
    return "example";
  }
}
