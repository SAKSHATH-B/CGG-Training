package com.cgg.Persistance;

import java.sql.Statement;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class EvictAndClear {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Person person = session.get(Person.class, 1);
      System.out.println(person.getName());

      //   session.evict(person);
      session.clear();
      System.out.println("=====================");
      person = session.get(Person.class, 1);
      System.out.println(person.getName());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
