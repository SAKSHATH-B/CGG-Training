package com.cgg.hql.OneToOne;

import java.util.Date;
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
      session.beginTransaction();

      Employee employee = new Employee();
      employee.setEmployeeName("hello3");
      employee.setEmail("hello3@gmail.com");
      employee.setSalary(200000.00);
      employee.setDoj(new Date());

      Address address1 = new Address();
      address1.setCity("chennai");
      address1.setPincode(23745237l);
      address1.setState("TN");
      address1.setStreet("street");

      employee.setAddress(address1);

      session.persist(employee);
      // session.persist(address1);
      System.out.println("Created/inserted...");
      session.getTransaction().commit();
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
