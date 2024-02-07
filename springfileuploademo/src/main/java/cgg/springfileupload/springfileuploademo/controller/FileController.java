package cgg.springfileupload.springfileuploademo.controller;

import cgg.springfileupload.springfileuploademo.payloads.FileResponse;
import cgg.springfileupload.springfileuploademo.services.FileService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

  @Autowired
  private FileService fileService;

  @Value("${project.images}")
  private String path;

  Logger logger = LoggerFactory.getLogger(FileController.class);

  @PostMapping("/upload")
  public ResponseEntity<FileResponse> uploadFile(
    @RequestParam("image") MultipartFile file
  ) {
    String fileName = null;
    try {
      //validations
      if (file.isEmpty()) {
        return new ResponseEntity<FileResponse>(
          new FileResponse(null, "Image is not uploaded due to server error.."),
          HttpStatus.INTERNAL_SERVER_ERROR
        );
      }

      if (!file.getContentType().equals("image/jpeg")) {
        return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(
            new FileResponse(
              file.getOriginalFilename(),
              "Only JPEG content allowed"
            )
          );
      }

      fileName = fileService.uploadImage(path, file);
    } catch (IOException e) {
      e.printStackTrace();
      return new ResponseEntity<FileResponse>(
        new FileResponse(
          null,
          "image is not uploaded due to error on server.."
        ),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
    return new ResponseEntity<FileResponse>(
      new FileResponse(fileName, "image successfully uploaded.."),
      HttpStatus.OK
    );
  }

  @GetMapping(
    value = "/images/{imageName}",
    produces = MediaType.IMAGE_JPEG_VALUE
  )
  public void downloadImage(
    @PathVariable String imageName,
    HttpServletResponse resp
  ) throws IOException {
    InputStream is = fileService.getResource(path, imageName);
    resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
    StreamUtils.copy(is, resp.getOutputStream());
  }

  //upload multiple files
  @PostMapping("/upload-files")
  public ResponseEntity<?> uploadMultipleFiles(
    @RequestParam("images") MultipartFile[] files
  ) {
    logger.info("{} number of files uploaded", files.length);
    Arrays
      .stream(files)
      .forEach(multipartFile -> {
        logger.info("file name : {}", multipartFile.getOriginalFilename());
        logger.info("file Type : {}", multipartFile.getContentType());
        System.out.println("==========================");
      });
    return ResponseEntity.ok("files uploaded");
  }
}
