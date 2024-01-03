package com.cgg.Fetching;

import java.util.Collections;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DynamicFetchusingJPAEntityGraph {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long employeeId = 1L;

      Employee employee = session.find(
        Employee.class,
        employeeId,
        Collections.singletonMap(
          "javax.persistence.EntityGraph",
          "employee.projects"
        )
      );

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
