package com.cgg.Fetching;

import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

public class DynamicCriteriaQueryFetching {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      String username = "barryj";
      String password = "barry@123";

      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Employee> query = builder.createQuery(Employee.class);
      JpaRoot<Employee> root = query.from(Employee.class);

      root.fetch("projects", JoinType.LEFT);
      query
        .select(root)
        .where(
          builder.and(
            builder.equal(root.get("username"), username),
            builder.equal(root.get("password"), password)
          )
        );

      Employee employee = session.createQuery(query).getSingleResult();

      if (employee != null) {
        System.out.println("Employee Details ============");
        System.out.println(
          employee.getId() +
          "\t" +
          employee.getEmployeeName() +
          "\t" +
          employee.getUserName() +
          "\t" +
          employee.getPassword() +
          "\t" +
          employee.getAccesslevel()
        );

        System.out.println("Employee Project details ========");
        List<Project> projects = employee.getProjects();
        for (Project project : projects) {
          System.out.println(project.getId() + "\t" + project.getProjectName());
        }

        System.out.println("Employee Department Details ===========");
        Department department = employee.getDepartment();
        if (department != null) {
          System.out.println(
            department.getId() + "\t" + department.getDeptName()
          );
        } else {
          System.out.println("Dept details not found");
        }
      } else {
        System.out.println("Employee not Found");
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
