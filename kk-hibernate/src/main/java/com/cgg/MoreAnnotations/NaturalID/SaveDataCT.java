package com.cgg.MoreAnnotations.NaturalID;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

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
      // Isbn isbn1 = new Isbn("900-9730228524", "911-9730228524");
      book1.setIsbn("900-9730228524");
      book1.setTitle("Hibernate High-Performance Java Persistence");
      book1.setAuthor(author1);

      Book book2 = new Book();
      // Isbn isbn2 = new Isbn("912-9730228524", "913-9730228524");
      book2.setIsbn("911-9730228524");
      book2.setTitle("Hibernate Persistence Contexts");
      book2.setAuthor(author1);

      //testing for default column values
      // Book book3 = new Book();
      // book3.setAuthor(author1);

      //testing for unique column constraints
      // Book book4 = new Book();
      // Isbn isbn3 = new Isbn("912-9730228524", "913-9730228524");
      // book4.setIsbn(isbn3);
      // book4.setTitle("Hibernate Persistence Contexts");
      // book4.setAuthor(author1);

      author1.getBooks().add(book1);
      author1.getBooks().add(book2);
      // author1.getBooks().add(book3);
      // author1.getBooks().add(book4);

      session.beginTransaction();
      session.persist(author1);

      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
