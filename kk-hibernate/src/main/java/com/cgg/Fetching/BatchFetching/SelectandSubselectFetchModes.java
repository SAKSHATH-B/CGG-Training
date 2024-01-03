package com.cgg.Fetching.BatchFetching;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SelectandSubselectFetchModes {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      List<Department> departments = session
        .createQuery("from Department", Department.class)
        .getResultList();
      System.out.println("Size of Depts : " + departments.size());

      for (Department department : departments) {
        System.out.println("Department Id : " + department.getId());
        System.out.println(
          "Employees Size : " + department.getEmployees().size()
        );
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
