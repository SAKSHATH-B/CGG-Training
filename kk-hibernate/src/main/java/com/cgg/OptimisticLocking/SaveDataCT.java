package com.cgg.OptimisticLocking;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveDataCT {

  public static void main(String[] args) {
    Transaction tx = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      tx = session.beginTransaction();

      Person person1 = new Person();
      person1.setPersonName("Sean Murphy");
      person1.setUsername("seanm");
      person1.setPassword("pass#123");
      person1.setAccessLevel(1);

      Person person2 = new Person();
      person2.setPersonName("Barry Johnson");
      person2.setUsername("barryj");
      person2.setPassword("barry@123");
      person2.setAccessLevel(1);

      session.persist(person1);
      session.persist(person2);

      tx.commit();
    } catch (Exception e) {
      if (tx != null && tx.isActive()) tx.rollback();
      throw e;
    }
  }
}
