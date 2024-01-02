package com.cgg.MoreAnnotations.FormulaAnnotation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ClientTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Account account = new Account();
      account.setCredit(9000.00);
      account.setRate(8.35);
      session.beginTransaction();
      session.persist(account);
      session.getTransaction().commit();
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
