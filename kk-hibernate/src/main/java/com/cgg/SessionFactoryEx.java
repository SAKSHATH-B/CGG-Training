package com.cgg;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactoryEx {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession();
    ) {
      String SQL = "select version();";
      String result = (String) session
        .createNativeQuery(SQL, String.class)
        .getSingleResult();
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
