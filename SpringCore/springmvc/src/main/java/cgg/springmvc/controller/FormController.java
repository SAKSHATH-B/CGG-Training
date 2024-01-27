package cgg.springmvc.controller;

import cgg.springmvc.entities.Student;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.setDisallowedFields(new String[] { "address.city" });
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    binder.registerCustomEditor(
      Date.class,
      "dob",
      new CustomDateEditor(dateFormat, false)
    );
  }

  @GetMapping("/complex")
  public String showForm() {
    return "complexform";
  }

  @RequestMapping(value = "/handleForm", method = RequestMethod.POST)
  public String handleForm(
    @ModelAttribute Student student,
    BindingResult result
  ) {
    if (result.hasErrors()) {
      return "complexform";
    }
    return "done";
  }
}
