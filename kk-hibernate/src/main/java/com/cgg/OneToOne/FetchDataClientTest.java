package com.cgg.OneToOne;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchDataClientTest {

  public static void main(String[] args) {
    // getEmployeeAndAddressByEmpId();
    getEmployeeAndAddressByAddressId();
  }

  private static void getEmployeeAndAddressByAddressId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Address address = session.get(Address.class, 1);
      System.out.println(address);
      System.out.println(address.getEmployee());
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void getEmployeeAndAddressByEmpId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Employee employee = session.get(Employee.class, 1);
      System.out.println(employee);
      // Address address = employee.getAddress();
      // System.out.println(address);
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
