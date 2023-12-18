package cgg.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    System.out.println("Program Started");
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    System.out.println(sessionFactory);
    System.out.println(sessionFactory.isClosed());
  }
}
