package com.cgg.BatchProcessing;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateCT {

  public static void main(String[] args) {
    Transaction tx = null;
    ScrollableResults scroll = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      tx = session.beginTransaction();
      int batchSize = 25;

      scroll =
        session
          .createQuery("select p from Person p")
          .setCacheMode(CacheMode.IGNORE)
          .scroll(ScrollMode.FORWARD_ONLY);

      int count = 0;
      while (scroll.next()) {
        Person person = (Person) scroll.get();
        processPerson(person);
        if (++count % batchSize == 0) {
          System.out.println("Session is flushed");
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
    } finally {
      if (scroll != null) {
        scroll.close();
      }
    }
  }

  private static void processPerson(Person person) {
    person.setFirstName(person.getFirstName() + "_updated");
  }
}
