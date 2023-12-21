package com.cgg.hql.AggregateFunc;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AggFuncTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      //using general method
      //   String HQL =
      //     "select count(e),AVG(e.salary),MIN(e.salary),SUM(e.salary) from Employee e";
      //   Query<Object[]> query = session.createQuery(HQL, Object[].class);
      //   List<Object[]> list = query.list();
      //   for (Object[] objects : list) {
      //     Long empCount = (Long) objects[0];
      //     Double avgSal = (Double) objects[1];
      //     Double minSal = (Double) objects[2];
      //     Double sumSal = (Double) objects[3];
      //     System.out.println("Employees count : " + empCount);
      //     System.out.println("Average salary : " + avgSal);
      //     System.out.println("min salary : " + minSal);
      //     System.out.println("Sum of all salaries of employees : " + sumSal);
      //   }

      //using EmployeeStatistics class
      String HQL =
        "select new EmployeeStatistics(count(e),AVG(e.salary),MIN(e.salary),SUM(e.salary)) from Employee e";
      Query<EmployeeStatistics> query = session.createQuery(
        HQL,
        EmployeeStatistics.class
      );
      EmployeeStatistics employeeStatistics = query.uniqueResult();
      System.out.println(employeeStatistics);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
