package com.cgg.Fetching.BatchFetching;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class JoinFetchModeTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Long departmentId = 1L;
      Department department = session.get(Department.class, departmentId);

      if (department != null) {
        System.out.println("Department Id : " + department.getId());
        List<Employee> employees = department.getEmployees();
        System.out.println("Employees Count : " + employees.size());
      } else {
        System.out.println("No Dept Found");
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
