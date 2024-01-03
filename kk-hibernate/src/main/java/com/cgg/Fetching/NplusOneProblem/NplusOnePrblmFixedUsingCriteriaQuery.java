package com.cgg.Fetching.NplusOneProblem;

import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

public class NplusOnePrblmFixedUsingCriteriaQuery {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Department> query = builder.createQuery(
        Department.class
      );
      JpaRoot<Department> root = query.from(Department.class);
      root.fetch("employees", JoinType.LEFT);
      query.select(root);

      List<Department> departments = session.createQuery(query).getResultList();

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
