package com.cgg.MoreAnnotations.NaturalID;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class updateNaturalId {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      // long ID = 2L;
      // Book book = session.get(Book.class, ID);
      // if (book != null) {
      //   session.beginTransaction();
      //   // book.setIsbn("901-9730228524");
      //   session.getTransaction().commit();
      // }

      //immutable objects values cannot be changed which gives an error
      // long ID = 2L;
      // Book book = session.get(Book.class, ID);
      // if (book != null) {
      //   session.beginTransaction();
      //   book.setTitle("Hibernate Persistence Contexts 2");
      //   session.getTransaction().commit();
      // }

      System.out.println("================================");
      //retrive natural id by naturalId method
      Book book2 = session
        .byNaturalId(Book.class)
        // .using("isbn", "978-9730228236")
        .using("isbn", new Isbn("900-9730228524", "911-9730228524"))
        .load();
      System.out.println(book2.getTitle());
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
