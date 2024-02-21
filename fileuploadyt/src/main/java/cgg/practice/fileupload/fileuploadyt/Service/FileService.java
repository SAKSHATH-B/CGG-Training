package cgg.practice.fileupload.fileuploadyt.Service;

import cgg.practice.fileupload.fileuploadyt.Repos.FileRepo;
import cgg.practice.fileupload.fileuploadyt.Repos.FileSystemRepo;
import cgg.practice.fileupload.fileuploadyt.entities.File;
import cgg.practice.fileupload.fileuploadyt.entities.FileSystem;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

  @Autowired
  private FileRepo fileRepo;

  @Autowired
  private FileSystemRepo fileSystemRepo;

  private static final String FOLDER_PATH =
    "C:\\Users\\CGG\\Documents\\Training\\fileuploadyt\\src\\main\\resources\\static\\images\\";

  public String uploadImage(MultipartFile file) throws IOException {
    File save = fileRepo.save(
      File
        .builder()
        .name(file.getOriginalFilename())
        .type(file.getContentType())
        .filedata(file.getBytes())
        .build()
    );
    if (save != null) {
      return "File uploaded successfully !! -- " + file.getOriginalFilename();
    }
    return "something went wrong !!";
  }

  public byte[] downloadImage(String filename) {
    byte[] filedata = fileRepo.findByName(filename).get().getFiledata();
    System.out.println(filedata);
    return filedata;
  }

  public String uploadImageToFileSystem(MultipartFile file) throws IOException {
    String filePath = FOLDER_PATH + file.getOriginalFilename();
    System.out.println(filePath);
    FileSystem fileSystem = fileSystemRepo.save(
      FileSystem
        .builder()
        .name(file.getOriginalFilename())
        .type(file.getContentType())
        .filepath(filePath)
        .build()
    );

    file.transferTo(new java.io.File(filePath));
    if (fileSystem != null) {
      return "File uploaded successfully !! -- " + filePath;
    }
    return "something went wrong !!";
  }

  public byte[] downloadImageFromFileSystem(String filename)
    throws IOException {
    String filepath = fileSystemRepo.findByName(filename).get().getFilepath();

    Path path = Paths.get(filepath);

    // byte[] allBytes = Files.readAllBytes(new java.io.File(filepath).toPath());
    byte[] allBytes = Files.readAllBytes(path);
    return allBytes;
  }
}
