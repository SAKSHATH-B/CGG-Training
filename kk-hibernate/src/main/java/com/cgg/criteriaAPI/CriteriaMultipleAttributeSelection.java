package com.cgg.criteriaAPI;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPath;
import org.hibernate.query.criteria.JpaRoot;

public class CriteriaMultipleAttributeSelection {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Object[]> criteriaQuery = builder.createQuery(
        Object[].class
      );
      JpaRoot<Employee> root = criteriaQuery.from(Employee.class);
      JpaPath<Object> employeeNamePath = root.get("employeeName");
      JpaPath<Object> emailPath = root.get("email");
      JpaPath<Object> salaryPath = root.get("salary");

      // criteriaQuery.select(
      //   builder.array(employeeNamePath, emailPath, salaryPath)
      // );

      criteriaQuery.multiselect(employeeNamePath, emailPath, salaryPath);

      Query<Object[]> query = session.createQuery(criteriaQuery);
      List<Object[]> list = query.list();
      for (Object[] objects : list) {
        System.out.println("Employee Name: " + (String) objects[0]);
        System.out.println("Email: " + (String) objects[1]);
        System.out.println("Salary: " + (Double) objects[2]);
      }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
