package com.cgg.LazyandEager;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchDataClientTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Employee employee = session.get(Employee.class, 1);
      System.out.println(employee);
      // if (employee != null) {
      //   employee.getAddressList().forEach(System.out::println);
      // }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
