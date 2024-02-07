package cgg.springboot.restapi.springbootrestapi.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

  // public static final String UPLOAD_DIR =
  //   "C:\\Users\\CGG\\Documents\\Training\\springbootrestapi\\src\\main\\resources\\static\\images";

  public final String UPLOAD_DIR = new ClassPathResource("static/images/")
    .getFile()
    .getAbsolutePath();

  public FileUploadHelper() throws IOException {}

  public Boolean uploadFile(MultipartFile file) {
    Boolean f = false;
    try {
      System.out.println(UPLOAD_DIR);
      Files.copy(
        file.getInputStream(),
        Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
        StandardCopyOption.REPLACE_EXISTING
      );
      f = true;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return f;
  }
}
