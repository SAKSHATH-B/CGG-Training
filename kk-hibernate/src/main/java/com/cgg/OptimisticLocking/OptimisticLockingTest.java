package com.cgg.OptimisticLocking;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OptimisticLockingTest {

  public static void main(String[] args) {
    Transaction tx = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Long perosnId = 1L;
      Person person = session.get(Person.class, perosnId);
      if (person != null) {
        tx = session.beginTransaction();
        person.setPassword("pass@1234");
        session.merge(person);
        tx.commit();
      } else {
        System.out.println("Person details not found with ID: " + perosnId);
      }
    } catch (Exception e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();
      }
    }
  }
}
