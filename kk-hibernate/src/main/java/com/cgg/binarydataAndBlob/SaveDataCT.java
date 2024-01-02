package com.cgg.binarydataAndBlob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;

public class SaveDataCT {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Person author1 = new Person();
      author1.setName("Gavin King");

      Book book1 = new Book();
      book1.setIsbn("978-9730228236");
      book1.setTitle("Hibernate High-Performance Java Persistence");
      book1.setAuthor(author1);

      Book book2 = new Book();
      book2.setIsbn("900-9730228524");
      book2.setTitle("Hibernate Persistence Contexts");
      book2.setAuthor(author1);

      author1.getBooks().add(book1);
      author1.getBooks().add(book2);

      session.doWork(conn ->
        author1.setProfilePic(BlobProxy.generateProxy(getImage()))
      );

      session.beginTransaction();
      //session.save(author1);
      session.persist(author1);
      // session.saveOrUpdate(author1);

      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static byte[] getImage() {
    Path path = Paths.get("src/main/java/com/cgg/binarydataAndBlob/hello.jpg");
    byte[] data = null;
    try {
      data = Files.readAllBytes(path);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return data;
  }
}
