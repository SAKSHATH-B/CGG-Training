package com.cgg.MergeandUpdateCascade;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class MergeUpdateCascade {

  public static void main(String[] args) {
    Employee employee1 = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      employee1 = session.get(Employee.class, 1);
      System.out.println(employee1);
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    employee1.setSalary(55000.00);
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      session.beginTransaction();
      Employee employee2 = session.get(Employee.class, 1);
      session.merge(employee1);
      session.getTransaction().commit();
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
