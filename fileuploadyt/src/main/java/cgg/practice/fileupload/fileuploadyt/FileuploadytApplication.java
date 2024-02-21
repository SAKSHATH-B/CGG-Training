package cgg.practice.fileupload.fileuploadyt;

import cgg.practice.fileupload.fileuploadyt.Service.FileService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
@RequestMapping("/file")
public class FileuploadytApplication {

  @Autowired
  private FileService fileService;

  @PostMapping("/upload")
  public ResponseEntity<?> uploadImage(
    @RequestParam("image") MultipartFile file
  ) throws IOException {
    String uploadImage = fileService.uploadImage(file);
    return ResponseEntity.ok(uploadImage);
  }

  @GetMapping("/{filename}")
  public ResponseEntity<?> downloadImage(@PathVariable String filename) {
    byte[] downloadImage = fileService.downloadImage(filename);

    return ResponseEntity
      .status(HttpStatus.OK)
      .contentType(MediaType.valueOf("image/jpeg"))
      .body(downloadImage);
  }

  @PostMapping("/filesystem")
  public ResponseEntity<?> uploadImageToFileSystem(
    @RequestParam("image") MultipartFile file
  ) throws IOException {
    String uploadImage = fileService.uploadImageToFileSystem(file);
    return ResponseEntity.ok(uploadImage);
  }

  @GetMapping("/filesystem/{filename}")
  public ResponseEntity<?> downloadImageFromFileSystem(
    @PathVariable String filename
  ) throws IOException {
    byte[] downloadImage = fileService.downloadImageFromFileSystem(filename);

    return ResponseEntity
      .status(HttpStatus.OK)
      .contentType(MediaType.valueOf("image/jpeg"))
      .body(downloadImage);
  }

  public static void main(String[] args) {
    SpringApplication.run(FileuploadytApplication.class, args);
  }
}
