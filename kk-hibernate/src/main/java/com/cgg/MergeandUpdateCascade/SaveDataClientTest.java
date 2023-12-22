package com.cgg.MergeandUpdateCascade;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SaveDataClientTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      session.beginTransaction();
      Employee employee = new Employee();
      employee.setEmployeeName("pK Bingek");
      employee.setEmail("PK.cs2017@gmail.com");
      employee.setSalary(30000.00);
      employee.setDoj(new Date());
      session.persist(employee);
      session.getTransaction().commit();
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
