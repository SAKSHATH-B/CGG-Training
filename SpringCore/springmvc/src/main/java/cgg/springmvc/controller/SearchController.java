package cgg.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

  @RequestMapping(path = "/search", method = RequestMethod.GET)
  public String search() {
    System.out.println("Going to home view");
    return "home";
  }

  @RequestMapping("/query")
  public String query(@RequestParam("querybox") String query) {
    String url = "https://www.google.com/search?q=" + query;
    return "redirect:" + url;
  }
}
