package com.cgg.Fetching.NplusOneProblem;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class NplusOnePrblmFixedUsingHQL {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      //   List<Department> departments = session
      //     .createQuery("from Department", Department.class)
      //     .getResultList();
      List<Department> departments = session
        .createQuery(
          "from Department d join fetch d.employees",
          Department.class
        )
        .getResultList();
      for (Department department : departments) {
        System.out.println("Department Details-----");
        System.out.println(
          department.getId() + "\t" + department.getDeptName()
        );
        List<Employee> employees = department.getEmployees();
        for (Employee employee : employees) {
          System.out.println(
            employee.getId() +
            "\t" +
            employee.getEmployeeName() +
            "\t" +
            employee.getUsername() +
            "\t" +
            employee.getPassword() +
            "\t" +
            employee.getAccessLevel()
          );
        }
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
