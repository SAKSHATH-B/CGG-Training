package com.cgg.MoreAnnotations.FormulaAnnotation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchCT {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long accountId = 1;
      Account account = session.get(Account.class, accountId);
      System.out.println("Account ID : " + account.getId());
      System.out.println("Credit amount : " + account.getCredit());
      System.out.println("Rate amount : " + account.getRate());
      System.out.println("Interest amount : " + account.getInterest());
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
