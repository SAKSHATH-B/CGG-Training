package com.cgg;

import java.time.Instant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    SessionFactory sessionFactory = connection.getSessionFactory();
    Session session = sessionFactory.openSession();

    Instant singleResult = session
      .createNativeQuery("select now();", Instant.class)
      .getSingleResult();
    System.out.println(singleResult);
  }
}
