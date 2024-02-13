package cgg.smartcontactmanager.smartcontactmanager.controllers;

import cgg.smartcontactmanager.smartcontactmanager.dao.UserRepository;
import cgg.smartcontactmanager.smartcontactmanager.entities.Contact;
import cgg.smartcontactmanager.smartcontactmanager.entities.Message;
import cgg.smartcontactmanager.smartcontactmanager.entities.User;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
@MultipartConfig
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/index")
  public String dashboard(
    Model model,
    Principal principal,
    HttpSession session
  ) {
    String userName = principal.getName();
    System.out.println("USERNAME : " + userName);
    User user = userRepository.findByName(userName);
    System.out.println("USER : " + user);
    model.addAttribute("title", "User Dashboard");
    // model.addAttribute("user", user);
    session.setAttribute("user", user);
    return "normal/user_dashboard";
  }

  @GetMapping("/add-contact")
  public String openAddContactForm(
    Model model,
    Principal principal,
    HttpSession session,
    @ModelAttribute("check") String check
  ) {
    model.addAttribute("title", "Add Contact");
    model.addAttribute("contact", new Contact());
    if (check.isEmpty()) {
      session.removeAttribute("message");
    }

    return "normal/add_contact_form";
  }

  @PostMapping("/process-contact")
  public String processContact(
    @ModelAttribute Contact contact,
    Principal principal,
    Model model,
    HttpSession session,
    @RequestParam("profileImage") MultipartFile file,
    RedirectAttributes ra
  ) {
    String name = principal.getName();
    User user = userRepository.findByName(name);

    if (!file.isEmpty()) {
      try {
        contact.setImage(file.getOriginalFilename());
        File saveFile = new ClassPathResource("static/img").getFile();
        System.out.println(saveFile);
        Path path = Paths.get(
          saveFile.getAbsolutePath() +
          File.separator +
          file.getOriginalFilename()
        );
        System.out.println(path);
        Files.copy(
          file.getInputStream(),
          path,
          StandardCopyOption.REPLACE_EXISTING
        );
        System.out.println("Image is uploaded");
      } catch (Exception e) {
        System.err.println("Failed to upload image: " + e.getMessage());
      }
    }

    contact.setUser(user);
    user.getContacts().add(contact);
    User saveduser = userRepository.save(user);
    if (saveduser != null) {
      session.setAttribute(
        "message",
        new Message("Contact added successfully...", "alert-success")
      );
      ra.addFlashAttribute("check", "yes");
      return "redirect:/user/add-contact";
    }
    session.setAttribute(
      "message",
      new Message("Something went wrong !!!", "alert-danger")
    );
    System.out.println("DATA : " + contact.toString());
    System.out.println("Added to DB");
    return "redirect:/user/add-contact";
  }
}
