package com.cgg.criteriaAPI.AggregateFuncJoinGrpByHaving;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

public class GrpByHavingTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
      JpaRoot<Employee> root = criteria.from(Employee.class);

      criteria.multiselect(
        builder.count(root.get("name")),
        builder.sum(root.get("salary")),
        root.get("department")
      );
      criteria.groupBy(root.get("department"));
      criteria.having(
        builder.greaterThan(builder.sum(root.get("salary")), 200000.00)
      );

      Query<Object[]> query = session.createQuery(criteria);
      List<Object[]> resultList = query.getResultList();
      for (Object[] objects : resultList) {
        Department department = (Department) objects[2];
        System.out.println(department.getId() + "\t" + department.getName());
        Long count = (Long) objects[0];
        System.out.println("Count : " + count);
        Double salarySum = (Double) objects[1];
        System.out.println("Total Salary : " + salarySum);
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}
