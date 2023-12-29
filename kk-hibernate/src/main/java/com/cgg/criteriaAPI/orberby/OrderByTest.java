package com.cgg.criteriaAPI.orberby;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

public class OrderByTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
      JpaRoot<Employee> root = criteria.from(Employee.class);
      criteria.select(root);
      criteria.orderBy(builder.asc(root.get("salary")));

      List<Employee> resultList = session.createQuery(criteria).getResultList();
      for (Employee employee : resultList) {
        System.out.println(
          "Employee Name : " +
          employee.getName() +
          "\t" +
          "Salary : " +
          employee.getSalary()
        );
      }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
