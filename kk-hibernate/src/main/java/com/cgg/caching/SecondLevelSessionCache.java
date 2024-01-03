package com.cgg.caching;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SecondLevelSessionCache {

  public static void main(String[] args) {
    Session session = null;
    try {
      session =
        new Configuration().configure().buildSessionFactory().openSession();
      Long employeeId = 1L;
      Employee employee = session.get(Employee.class, employeeId);
      System.out.println(employee);
      System.out.println("---------------------");
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      if (session != null) {
        session.close();
      }
    }

    try {
      session =
        new Configuration().configure().buildSessionFactory().openSession();
      Long employeeId = 1L;
      Employee employee = session.get(Employee.class, employeeId);
      System.out.println(employee);
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }
}
