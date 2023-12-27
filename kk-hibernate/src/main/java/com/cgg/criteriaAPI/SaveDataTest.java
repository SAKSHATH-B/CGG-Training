package com.cgg.criteriaAPI;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SaveDataTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      session.beginTransaction();
      Employee employee1 = new Employee();
      employee1.setEmployeeName("Martin Bingel");
      employee1.setEmail("martin.cs2017@gmail.com");
      employee1.setSalary(50000.00);
      employee1.setDoj(new Date());

      Employee employee2 = new Employee();
      employee2.setEmployeeName("Sean Murphy");
      employee2.setEmail("sean.m2017@gmail.com");
      employee2.setSalary(90000.00);
      employee2.setDoj(new Date());

      session.persist(employee1);
      session.persist(employee2);

      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
