package com.cgg.criteriaAPI.orberby;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SaveDataCT {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Employee employee1 = new Employee();
      employee1.setDesignation("Developer");
      employee1.setName("Sean Murphy");
      employee1.setSalary(70000.00);

      Employee employee2 = new Employee();
      employee2.setDesignation("Sr. Developer");
      employee2.setName("Martin Bingel");
      employee2.setSalary(50000.00);

      Employee employee3 = new Employee();
      employee3.setDesignation("Team Lead");
      employee3.setName("Barry Johnson");
      employee3.setSalary(90000.00);

      Employee employee4 = new Employee();
      employee4.setDesignation("Associate");
      employee4.setName("Arnold");
      employee4.setSalary(80000.00);

      Employee employee5 = new Employee();
      employee5.setDesignation("Sr. Associate");
      employee5.setName("Harry Johnson ");
      employee5.setSalary(60000.00);

      Employee employee6 = new Employee();
      employee6.setDesignation("AVP");
      employee6.setName("Jodi Albert");
      employee6.setSalary(980000.00);

      Employee employee7 = new Employee();
      employee7.setDesignation("VP");
      employee7.setName("Anthony Andrews");
      employee7.setSalary(100000.00);

      session.beginTransaction();

      session.persist(employee1);
      session.persist(employee2);
      session.persist(employee3);
      session.persist(employee4);
      session.persist(employee5);
      session.persist(employee6);
      session.persist(employee7);

      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
