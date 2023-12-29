package com.cgg.criteriaAPI.AggregateFuncJoinGrpByHaving;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaExpression;
import org.hibernate.query.criteria.JpaRoot;

public class Test {

  public static void main(String[] args) {
    // getTotalNoofEmp();
    // getMaxSalOfEmp();
    // getAvgSalOfEmp();
    // getSumOfSalOfEmp();
    // getDistinctNoOfEmp();

    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<EmployeeStatisticsDTO> criteria = builder.createQuery(
        EmployeeStatisticsDTO.class
      );
      JpaRoot<Employee> root = criteria.from(Employee.class);

      JpaExpression<Long> totalNoofEmp = builder.count(root);
      JpaExpression<Long> distinctNoOfEmp = builder.countDistinct(root);
      JpaExpression<Double> maxSalOfEmp = builder.max(root.get("salary"));
      JpaExpression<Double> avgSalOfEmp = builder.avg(root.get("salary"));
      JpaExpression<Number> sumOfSalOfEmp = builder.sum(root.get("salary"));

      criteria.select(
        builder.construct(
          EmployeeStatisticsDTO.class,
          totalNoofEmp,
          distinctNoOfEmp,
          maxSalOfEmp,
          avgSalOfEmp,
          sumOfSalOfEmp
        )
      );

      EmployeeStatisticsDTO result = session
        .createQuery(criteria)
        .getSingleResult();
      System.out.println(result);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private static void getDistinctNoOfEmp() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Long> criteria = builder.createQuery(Long.class);
      JpaRoot<Employee> root = criteria.from(Employee.class);
      criteria.select(builder.countDistinct(root));

      Long res = session.createQuery(criteria).getSingleResult();
      System.out.println("Total Distinct no of employees : " + res);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private static void getSumOfSalOfEmp() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Double> criteria = builder.createQuery(Double.class);
      JpaRoot<Employee> root = criteria.from(Employee.class);
      criteria.select(builder.sum(root.get("salary")));

      Double res = session.createQuery(criteria).getSingleResult();
      System.out.println("Sum of Salary of employees : " + res);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private static void getAvgSalOfEmp() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Double> criteria = builder.createQuery(Double.class);
      JpaRoot<Employee> root = criteria.from(Employee.class);
      criteria.select(builder.avg(root.get("salary")));

      Double res = session.createQuery(criteria).getSingleResult();
      System.out.println("Average Salary of employees : " + res);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private static void getMaxSalOfEmp() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Double> criteria = builder.createQuery(Double.class);
      JpaRoot<Employee> root = criteria.from(Employee.class);
      criteria.select(builder.max(root.get("salary")));

      Double res = session.createQuery(criteria).getSingleResult();
      System.out.println("Max Salary of employees : " + res);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private static void getTotalNoofEmp() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Long> criteria = builder.createQuery(Long.class);
      JpaRoot<Employee> root = criteria.from(Employee.class);
      criteria.select(builder.count(root));

      Long res = session.createQuery(criteria).getSingleResult();
      System.out.println("Total no of employees : " + res);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
