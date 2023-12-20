package com.cgg.LazyandEager;

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
      createEmployee(session);
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void createEmployee(Session session) {
    session.beginTransaction();
    session.persist(getEmployee());
    System.out.println("Created/inserted...");
    session.getTransaction().commit();
  }

  private static Employee getEmployee() {
    Employee employee = new Employee();
    employee.setEmployeeName("hello3");
    employee.setEmail("hello3@gmail.com");
    employee.setSalary(200000.00);
    employee.setDoj(new Date());

    Address homeAddress = new Address();
    homeAddress.setCity("chennai");
    homeAddress.setPincode(23745237l);
    homeAddress.setState("TN");
    homeAddress.setStreet("street");

    Address officeAddress = new Address();
    officeAddress.setCity("Hyderabad");
    officeAddress.setPincode(652433l);
    officeAddress.setState("TS");
    officeAddress.setStreet("Gachibowli");

    employee.setHomeAddress(homeAddress);
    employee.setOfficeAddress(officeAddress);

    employee.getAddressList().add(homeAddress);
    employee.getAddressList().add(officeAddress);

    return employee;
  }
}
