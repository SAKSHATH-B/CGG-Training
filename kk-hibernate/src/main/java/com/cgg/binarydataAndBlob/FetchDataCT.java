package com.cgg.binarydataAndBlob;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchDataCT {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long personId = 1l;
      Person person = session.get(Person.class, personId);
      System.out.println("Person Details : ");
      System.out.println("Id : " + person.getId());
      System.out.println("Name : " + person.getName());
      System.out.println("List of Books : ");
      List<Book> books = person.getBooks();
      for (Book book : books) {
        System.out.println(
          book.getId() + "\t" + book.getTitle() + "\t" + book.getIsbn()
        );
      }

      Blob image = person.getProfilePic();
      session.beginTransaction();
      if (image != null) {
        try (InputStream inputStream = image.getBinaryStream()) {
          Files.copy(
            inputStream,
            Paths.get("src/main/java/com/cgg/binarydataAndBlob/new.jpg"),
            StandardCopyOption.REPLACE_EXISTING
          );
          System.out.println("Image copied successfully.");
        } catch (IOException e) {
          e.printStackTrace();
          System.out.println("Error copying image: " + e.getMessage());
        } catch (SQLException e) {
          e.printStackTrace();
          System.out.println("SQL Exception: " + e.getMessage());
        }
      } else {
        System.out.println("No image found for this person.");
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
