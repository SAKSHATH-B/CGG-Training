package cgg.springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {

  @RequestMapping(path = "/home", method = RequestMethod.GET)
  public String home(Model model) {
    System.out.println("This is home method using home url...");
    model.addAttribute("name", "PanduGadu");
    model.addAttribute("id", 93);

    List<String> frnds = new ArrayList<>();
    frnds.add("Ramana");
    frnds.add("Gundu");
    frnds.add("Bharat");
    model.addAttribute("friends", frnds);
    return "index";
  }

  @GetMapping("/about")
  public String about() {
    System.out.println("This is about method using home url...");
    return "about";
  }

  @RequestMapping(path = "/help", method = RequestMethod.GET)
  public ModelAndView help() {
    System.out.println("This is help url...");
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("name", "Devudu");
    modelAndView.addObject("num", 1562);
    LocalDateTime dateTime = LocalDateTime.now();
    modelAndView.addObject("dateTime", dateTime);

    List<Integer> steps = new ArrayList<>();
    steps.add(1);
    steps.add(2);
    steps.add(3);
    steps.add(4);
    steps.add(5);
    modelAndView.addObject("steps", steps);

    modelAndView.setViewName("help");
    return modelAndView;
  }
}
