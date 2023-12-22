package com.cgg.hql.GroupByandHavingHQL;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLClientTest {

  public static void main(String[] args) {
    getEmployeeAndAddressByEmpId();
  }

  private static void getEmployeeAndAddressByEmpId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      //groupby clause to specify grouping column in both tables
      // String HQL =
      //   "select dept.departmentName,sum(emp.salary) from Department dept left join dept.employees emp group by dept";
      // Query<Object[]> query = session.createQuery(HQL, Object[].class);
      // List<Object[]> list = query.list();
      // for (Object[] objects : list) {
      //   String departmentName = (String) objects[0];
      //   Double totalSal = (Double) objects[1];
      //   System.out.println("Department Name: " + departmentName);
      //   System.out.println("Total Sal : " + totalSal);
      // }

      //having clause to specify condition
      String HQL =
        "select dept.departmentName,sum(emp.salary) from Department dept left join dept.employees emp group by dept having sum(emp.salary)>230000";
      Query<Object[]> query = session.createQuery(HQL, Object[].class);
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
}
