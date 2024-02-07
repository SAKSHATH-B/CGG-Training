package cgg.smartcontactmanager.smartcontactmanager.controllers;

import cgg.smartcontactmanager.smartcontactmanager.dao.UserRepository;
import cgg.smartcontactmanager.smartcontactmanager.entities.Message;
import cgg.smartcontactmanager.smartcontactmanager.entities.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @GetMapping("/test")
  @ResponseBody
  public String test() {
    User user = new User();
    user.setName("Hussain");
    user.setEmail("hussainman@gmail.com");
    userRepository.save(user);
    return "Working...";
  }

  @GetMapping("/home")
  public String home(Model model) {
    model.addAttribute("title", "Home-Smart Contact Manager");
    return "home";
  }

  @GetMapping("/about")
  public String about(Model model) {
    model.addAttribute("title", "About-Smart Contact Manager");
    return "about";
  }

  @RequestMapping("/signup")
  public String signup(Model model) {
    model.addAttribute("title", "Register-Smart Contact Manager");
    model.addAttribute("user", new User());
    return "signup";
  }

  @PostMapping("/do_register")
  public String registerUser(
    @Valid @ModelAttribute("user") User user,
    BindingResult result,
    @RequestParam(
      value = "agreement",
      defaultValue = "false"
    ) boolean agreement,
    Model model,
    HttpSession session
  ) {
    try {
      if (result.hasErrors()) {
        System.out.println("ERROR" + result.toString());
        model.addAttribute("user", user);
        return "signup";
      }
      if (!agreement) {
        System.out.println("you have not agreed the terms and conditions");
        throw new Exception("you have not agreed the terms and conditions");
      }
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setRole("ROLE_USER");
      user.setEnabled(true);
      user.setImageUrl("default.png");
      System.out.println("AGREEMENT " + agreement);
      System.out.println("USER " + user);
      User save = userRepository.save(user);

      session.setAttribute(
        "message",
        new Message("Successfully Registered...", "alert-success")
      );
      model.addAttribute("user", save);
      return "signup";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("user", user);
      session.setAttribute(
        "message",
        new Message("Something went wrong!!" + e.getMessage(), "alert-error")
      );
      return "signup";
    }
  }

  @GetMapping("/signin")
  public String customLogin(Model model) {
    model.addAttribute("title", "Login Page");
    return "login";
  }
  // @GetMapping("/logout")
  // public String logout() {
  //   return "logout";
  // }
}
