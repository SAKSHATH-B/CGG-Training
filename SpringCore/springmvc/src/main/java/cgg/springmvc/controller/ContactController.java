package cgg.springmvc.controller;

import cgg.springmvc.entities.User;
import cgg.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

  @Autowired
  private UserService userService;

  public ContactController(UserService userService) {
    this.userService = userService;
  }

  @ModelAttribute
  public void commonData(Model model) {
    model.addAttribute("head", "Centre for Good Governance");
    model.addAttribute("desc", "Home for Programming");
    System.out.println("Adding common data");
  }

  @RequestMapping("/contact")
  public String contact(Model model) {
    System.out.println("This is method of contact controller.");

    return "register";
  }

  @RequestMapping(path = "/processForm", method = RequestMethod.POST)
  public String processForm(@ModelAttribute User user, Model model) {
    System.out.println("processing form");

    if (user.getUser_name().isBlank()) {
      return "redirect:/contact";
    }

    userService.createUser(user);

    model.addAttribute("msg", "User Created with id : " + user.getUserId());
    // System.out.println(user);

    return "success";
  }
}
