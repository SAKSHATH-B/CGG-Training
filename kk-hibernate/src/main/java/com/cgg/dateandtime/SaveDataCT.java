package com.cgg.dateandtime;

import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SaveDataCT {

  public static void main(String[] args) {
    try (
      // Session session = new Configuration()
      //   .configure()
      //   .buildSessionFactory()
      //   .openSession()
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .withOptions()
        .jdbcTimeZone(TimeZone.getTimeZone("UTC"))
        .openSession()
    ) {
      Person author1 = new Person();
      author1.setName("Gavin King");

      Book book1 = new Book();
      book1.setIsbn("978-9730228236");
      book1.setTitle("Hibernate High-Performance Java Persistence");
      book1.setPublishedDate(new Date());
      // book1.setPublishedDate(LocalDate.now());
      book1.setAuthor(author1);

      Book book2 = new Book();
      book2.setIsbn("900-9730228524");
      book2.setTitle("Hibernate Persistence Contexts");
      book2.setPublishedDate(new Date());
      // book2.setPublishedDate(LocalDate.now());
      book2.setAuthor(author1);

      author1.getBooks().add(book1);
      author1.getBooks().add(book2);

      session.beginTransaction();
      //session.save(author1);
      session.persist(author1);
      // session.saveOrUpdate(author1);

      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
