package cgg.springmvc.controller;

import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

  @GetMapping("/fileform")
  public String showUploadForm() {
    System.out.println("File Upload form");
    return "fileform";
  }

  @PostMapping("/uploadImage")
  public String fileUpload(
    @RequestParam("profile") MultipartFile file,
    HttpSession s,
    Model m
  ) {
    System.out.println("File Upload Controller");
    System.out.println(file.getSize());
    System.out.println(file.getContentType());
    System.out.println(file.getName());
    System.out.println(file.getOriginalFilename());
    byte[] data = null;
    try {
      data = file.getBytes();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //save file to server by using HTTPSESSION obj
    String path =
      s.getServletContext().getRealPath("/") +
      "WEB-INF" +
      File.separator +
      "resources" +
      File.separator +
      "images" +
      File.separator +
      file.getOriginalFilename();

    System.out.println(path);

    try {
      FileOutputStream fos = new FileOutputStream(path);
      fos.write(data);
      fos.close();
      System.out.println("File uploaded successfully...");
      m.addAttribute("msg", "File Uploaded...");
      m.addAttribute("filename", file.getOriginalFilename());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("file uploading error");
      m.addAttribute("msg", "uploading error...");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return "filesuccess";
  }

  @RequestMapping("/user/{userId}/{userName}")
  public String getUserDetails(
    @PathVariable("userId") int id,
    @PathVariable("userName") String name
  ) {
    System.out.println(id);
    System.out.println(name);
    int arr[] = { 12 };
    arr[1] = 14;

    Integer.parseInt(name);
    String str = null;
    System.out.println(str.length());
    return "home1";
  }
  //handling exceptions in spring mvc

  // @ExceptionHandler(value = NullPointerException.class)
  // public String exceptionHandler(Model m) {
  //   m.addAttribute("msg", "Null Pointer Exception Occured");
  //   return "error_page";
  // }

  // @ExceptionHandler(value = NumberFormatException.class)
  // public String numberFormatException(Model m) {
  //   m.addAttribute("msg", "Number format Exception Occured");
  //   return "error_page";
  // }

  // @ExceptionHandler(value = Exception.class)
  // public String genericException(Model m) {
  //   m.addAttribute("msg", "Exception occured");
  //   return "error_page";
  // }
}
