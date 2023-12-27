package com.cgg.hql.namednativequeries;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLClientTest {

  public static void main(String[] args) {
    getTotalSalbyDept();
    // getEmpbyId();
  }

  private static void getTotalSalbyDept() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Query<Object[]> query = session.createNamedQuery(
        "getTotalSalbyDept",
        Object[].class
      );
      List<Object[]> list = query.list();
      for (Object[] objects : list) {
        String departmentName = (String) objects[0];
        Double totalSal = (Double) objects[1];
        System.out.println("Department Name: " + departmentName);
        System.out.println("Total Sal : " + totalSal);
      }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void getEmpbyId() {
    int empId = 2;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Query<Employee> query = session.createNamedQuery(
        "Employee.byId",
        Employee.class
      );
      query.setParameter("empId", empId);
      Employee res = query.uniqueResult();
      System.out.println(res);
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
