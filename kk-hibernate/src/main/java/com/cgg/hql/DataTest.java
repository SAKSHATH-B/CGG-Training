package com.cgg.hql;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DataTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      session.beginTransaction();

      Employee employee1 = new Employee();
      employee1.setEmployeeName("barry johnson");
      employee1.setDesignation("Tester");
      employee1.setDoj(new Date());
      employee1.setEmail("barry.j1920@infotech.com");
      employee1.setBonus(new BigDecimal(1500));
      employee1.setSalary(50000.00);

      Employee employee2 = new Employee();
      employee2.setEmployeeName("Marry Johnson");
      employee2.setDesignation("HR");
      employee2.setDoj(new Date());
      employee2.setEmail("marry.j1920@infotech.com");
      employee2.setBonus(new BigDecimal(1000));
      employee2.setSalary(60000.00);

      session.persist(employee1);
      session.persist(employee2);

      session.getTransaction().commit();
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
