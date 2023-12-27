package com.cgg.criteriaAPI;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

public class CriteriaAttributeSelection {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<String> criteriaQuery = builder.createQuery(
        String.class
      );
      JpaRoot<Employee> root = criteriaQuery.from(Employee.class);
      criteriaQuery.select(root.get("employeeName"));

      // criteriaQuery.where(builder.equal(root.get("employeeId"), 2));

      Query<String> query = session.createQuery(criteriaQuery);
      List<String> list = query.list();
      list.forEach(System.out::println);
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
