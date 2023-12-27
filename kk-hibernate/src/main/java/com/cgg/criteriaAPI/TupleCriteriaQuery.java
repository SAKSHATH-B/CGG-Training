package com.cgg.criteriaAPI;

import jakarta.persistence.Tuple;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPath;
import org.hibernate.query.criteria.JpaRoot;

public class TupleCriteriaQuery {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Tuple> criteriaQuery = builder.createQuery(Tuple.class);
      JpaRoot<Employee> root = criteriaQuery.from(Employee.class);

      JpaPath<Object> employeeNamePath = root.get("employeeName");
      JpaPath<Object> emailPath = root.get("email");
      JpaPath<Object> salaryPath = root.get("salary");

      criteriaQuery.multiselect(employeeNamePath, emailPath, salaryPath);

      List<Tuple> tuples = session.createQuery(criteriaQuery).getResultList();
      for (Tuple tuple : tuples) {
        String employeeName = (String) tuple.get(employeeNamePath);
        String email = (String) tuple.get(emailPath);
        Double salary = (Double) tuple.get(salaryPath);
        System.out.println(employeeName + "\t" + email + "\t" + salary);
      }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
