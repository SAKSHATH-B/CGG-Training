package com.cgg.BatchProcessing;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AntiPatternBatchInsertCT {

  public static void main(String[] args) {
    Transaction tx = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      tx = session.beginTransaction();

      for (int i = 1; i <= 100; i++) {
        Person person = new Person();
        person.setFirstName("Martin_" + i);
        person.setLastName("Luther_" + i);
        session.persist(person);
      }

      tx.commit();
    } catch (HibernateException e) {
      if (tx != null && tx.isActive()) {
        tx.rollback();
      }
      throw e;
    }
  }
}
