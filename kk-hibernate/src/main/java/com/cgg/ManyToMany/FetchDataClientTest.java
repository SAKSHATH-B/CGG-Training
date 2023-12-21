package com.cgg.ManyToMany;

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
      Address address = session.get(Address.class, 2);
      System.out.println(address);
      if (address != null) {
        address.getEmpList().forEach(System.out::println);
      }
    } catch (HibernateException e) {
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
      Employee employee = session.get(Employee.class, 2);
      System.out.println(employee);
      if (employee != null) {
        employee.getAddressList().forEach(System.out::println);
      }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
