package com.cgg.Persistance;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DeleteEntity {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long personId = 1l;
      Person person = session.get(Person.class, personId);
      if (person != null) {
        session.beginTransaction();
        session.remove(person);
        session.getTransaction().commit();
      } else {
        System.out.println("Person doesn't exist");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
