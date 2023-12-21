package com.cgg.ManyToMany;

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

      Employee employee1 = new Employee();
      employee1.setEmployeeName("hello1");
      employee1.setEmail("hello1@gmail.com");
      employee1.setSalary(2000.00);
      employee1.setDoj(new Date());

      Employee employee2 = new Employee();
      employee2.setEmployeeName("hello2");
      employee2.setEmail("hello2@gmail.com");
      employee2.setSalary(20000.00);
      employee2.setDoj(new Date());

      Address address1 = new Address();
      address1.setCity("chennai");
      address1.setPincode(23745237l);
      address1.setState("TN");
      address1.setStreet("street");

      Address address2 = new Address();
      address2.setCity("Hyd");
      address2.setPincode(126367l);
      address2.setState("Ts");
      address2.setStreet("GCBWLI");

      Address address3 = new Address();
      address3.setCity("Delhi");
      address3.setPincode(7123571l);
      address3.setState("dl");
      address3.setStreet("pst street");

      employee1.getAddressList().add(address1);
      employee1.getAddressList().add(address2);
      employee1.getAddressList().add(address3);

      address1.getEmpList().add(employee1);
      address2.getEmpList().add(employee1);
      address3.getEmpList().add(employee1);

      employee2.getAddressList().add(address2);
      employee2.getAddressList().add(address3);

      address2.getEmpList().add(employee2);
      address3.getEmpList().add(employee2);

      session.persist(employee1);
      session.persist(employee2);

      System.out.println("Created/inserted...");
      session.getTransaction().commit();
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
