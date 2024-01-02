package com.cgg.BatchProcessing;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BatchInsertCT {

  public static void main(String[] args) {
    int batchSize = 25;
    Transaction tx = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      tx = session.beginTransaction();

      for (int i = 1; i <= 1000; i++) {
        Person person = new Person();
        person.setFirstName("Luther_" + i);
        person.setLastName("King_" + i);
        session.persist(person);
        if (i > 0 && i % batchSize == 0) {
          System.out.println("Flush and clear the session");
          session.flush();
          session.clear();
        }
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
