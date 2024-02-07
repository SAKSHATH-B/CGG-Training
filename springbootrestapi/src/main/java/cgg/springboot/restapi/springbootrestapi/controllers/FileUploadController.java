package cgg.springboot.restapi.springbootrestapi.controllers;

import cgg.springboot.restapi.springbootrestapi.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

  @Autowired
  public FileUploadHelper fileUploadHelper;

  @PostMapping("/fileUpload")
  public ResponseEntity<String> file(@RequestParam("file") MultipartFile file) {
    // try {
    //   System.out.println(file.getInputStream());
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }
    // System.out.println(file.getOriginalFilename());
    // System.out.println(file.getSize());
    System.out.println(file.getContentType());
    // System.out.println(file.getName());

    // return ResponseEntity.ok("File Uploaded...");

    try {
      //validations
      if (file.isEmpty()) {
        return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Request must contain file..");
      }
      if (
        file
          .getOriginalFilename()
          .substring(file.getOriginalFilename().lastIndexOf(".") + 1)
          .equals("png")
      ) {
        return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Upload jpg/jpeg images only..");
      }
      // if (file.getContentType().equals("image/png")) {
      //   return ResponseEntity
      //     .status(HttpStatus.INTERNAL_SERVER_ERROR)
      //     .body("Upload jpg/jpeg images only..");
      // }

      //file uploaded code
      Boolean f = fileUploadHelper.uploadFile(file);
      if (f) {
        // return ResponseEntity.ok("File Uploaded...");
        return ResponseEntity.ok(
          ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path("/images/")
            .path(file.getOriginalFilename())
            .toUriString()
        );
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }

    // return ResponseEntity.ok("working...");
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body("Something went wrong on server...");
  }
}
