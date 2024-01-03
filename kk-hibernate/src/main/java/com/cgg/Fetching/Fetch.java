package com.cgg.Fetching;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Fetch {

  public static void main(String[] args) {
    // directEntityFetching();
    entityQueryFetching();
  }

  private static void entityQueryFetching() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long employeeId = 1l;
      Query query = session.createQuery(
        "select e from Employee e where e.id =: empId"
      );
      query.setParameter("empId", employeeId);
      Employee employee = (Employee) query.getSingleResult();

      if (employee != null) {
        System.out.println("Employee Details ===========");
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
        System.out.println("Employee Dept Details========");
        Department department = employee.getDepartment();
        if (department != null) {
          System.out.println(
            department.getId() + "\t" + department.getDeptName()
          );
        } else {
          System.out.println(
            "Dept details not found for employee Id : " + employeeId
          );
        }
      } else {
        System.out.println("Employee not Found with id : " + employeeId);
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

  private static void directEntityFetching() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Long employeeId = 1L;
      Employee employee = session.get(Employee.class, employeeId);

      if (employee != null) {
        System.out.println("Employee Details ===========");
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
        System.out.println("Employee Dept Details========");
        Department department = employee.getDepartment();
        if (department != null) {
          System.out.println(
            department.getId() + "\t" + department.getDeptName()
          );
        } else {
          System.out.println(
            "Dept details not found for employee Id : " + employeeId
          );
        }
      } else {
        System.out.println("Employee not Found with id : " + employeeId);
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
