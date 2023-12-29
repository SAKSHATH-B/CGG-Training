package com.cgg.criteriaAPI.AggregateFuncJoinGrpByHaving;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

public class JoinTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
      JpaRoot<Employee> rootEmp = criteria.from(Employee.class);
      JpaRoot<Department> rootDept = criteria.from(Department.class);

      criteria.multiselect(rootEmp, rootDept);
      criteria.where(
        builder.equal(rootEmp.get("department").get("id"), rootDept.get("id"))
      );

      Query<Object[]> query = session.createQuery(criteria);
      List<Object[]> resultList = query.getResultList();
      for (Object[] objects : resultList) {
        Employee employee = (Employee) objects[0];
        System.out.println(employee.getId() + "\t" + employee.getName());
        Department department = (Department) objects[1];
        System.out.println(department.getId() + "\t" + department.getName());
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}
