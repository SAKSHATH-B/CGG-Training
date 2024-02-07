package cgg.springfileupload.springfileuploademo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

  @Override
  public String uploadImage(String path, MultipartFile file)
    throws IOException {
    //get original file name
    String fileName = file.getOriginalFilename();

    //generate random file name
    String randomId = UUID.randomUUID().toString();
    String fileName1 = randomId.concat(
      fileName.substring(fileName.lastIndexOf("."))
    );

    //full path
    String fullPath = path + File.separator + fileName1;

    //create folder if not created
    File f = new File(path);
    if (!f.exists()) {
      f.mkdir();
    }

    //copy files
    Files.copy(file.getInputStream(), Paths.get(fullPath));
    return fileName1;
  }

  @Override
  public InputStream getResource(String path, String fileName)
    throws FileNotFoundException {
    String fullPath = path + File.separator + fileName;
    FileInputStream fileInputStream = new FileInputStream(fullPath);
    return fileInputStream;
  }
}
