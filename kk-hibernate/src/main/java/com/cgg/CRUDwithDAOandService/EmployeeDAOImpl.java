package com.cgg.CRUDwithDAOandService;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class EmployeeDAOImpl implements EmployeeDAO {

  @Override
  public void addEmployee(Employee employee) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      session.beginTransaction();
      session.persist(employee);
      System.out.println("Employee is created...");
      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Employee fetchEmployeebyId(int employeeId) {
    Employee employee = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      employee = session.get(Employee.class, employeeId);
      if (employee != null) {
        return employee;
      } else {
        System.out.println("Employee doesnt exist with provided ID...");
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void updateEmployee(int employeeId, Double newSal) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Employee employee = session.get(Employee.class, employeeId);
      if (employee != null) {
        employee.setSalary(newSal);
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
      } else {
        System.out.println("Employee doesnt exist with provided ID...");
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteEmployeebyId(int employeeId) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Employee employee = session.get(Employee.class, employeeId);
      if (employee != null) {
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
      } else {
        System.out.println("Employee doesnt exist with provided ID...");
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
