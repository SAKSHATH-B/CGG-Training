package com.cgg.Fetching;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class NoFetch {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      String username = "barryj";
      String password = "barry@123";

      Employee employee = session
        .createQuery(
          "select e from Employee e where e.username =: username and e.password=:password",
          Employee.class
        )
        .setParameter("username", username)
        .setParameter("password", password)
        .getSingleResult();

      if (employee != null) {
        System.out.println("Employee Details ===========");
        System.out.println(
          employee.getId() +
          "\t" +
          employee.getEmployeeName() +
          "\t" +
          employee.getUserName() +
          "\t" +
          employee.getPassword() +
          "\t" +
          employee.getAccesslevel()
        );
        System.out.println("Employee Dept Details========");
        Department department = employee.getDepartment();
        if (department != null) {
          System.out.println(
            department.getId() + "\t" + department.getDeptName()
          );
        } else {
          System.out.println("Dept details not found");
        }
      } else {
        System.out.println("Employee not Found");
      }

      //NoFetching Example
      Integer accesslevel = session
        .createQuery(
          "select e.accesslevel from Employee e where e.username =: username and e.password =: password",
          Integer.class
        )
        .setParameter("username", username)
        .setParameter("password", password)
        .getSingleResult();
      System.out.println("AccessLevel : " + accesslevel);
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
