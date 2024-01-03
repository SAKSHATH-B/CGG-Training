package com.cgg.caching;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevelSessionCacheCT {

  public static void main(String[] args) {
    // sessionCacheForInsertRecord();
    // sessionCacheReadByPrimaryKey();
    // sesionCacheForUpdateRecord();
    sesionCacheForDeleteRecord();
  }

  private static void sesionCacheForDeleteRecord() {
    Transaction tx = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Long employeeId = 2L;
      Employee employee1 = session.get(Employee.class, employeeId);
      System.out.println(employee1);
      if (employee1 != null) {
        tx = session.beginTransaction();
        session.delete(employee1);
        tx.commit();
      }
      System.out.println(
        "-------------------------------------------------------------"
      );
      Employee employee2 = session.get(Employee.class, employeeId);
      System.out.println(employee2);
    } catch (Exception e) {
      if (tx != null && tx.isActive()) tx.rollback();
      throw e;
    }
  }

  private static void sesionCacheForUpdateRecord() {
    Transaction tx = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Long employeeId = 1L;
      String newPassword = "password$23";
      Employee employee1 = session.get(Employee.class, employeeId);
      System.out.println(employee1);
      if (employee1 != null) {
        tx = session.beginTransaction();
        employee1.setPassword(newPassword);
        tx.commit();
      }
      System.out.println(
        "-------------------------------------------------------------"
      );
      Employee employee2 = session.get(Employee.class, employeeId);
      System.out.println(employee2);
    } catch (Exception e) {
      if (tx != null && tx.isActive()) tx.rollback();
      throw e;
    }
  }

  private static void sessionCacheReadByPrimaryKey() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Long employeeId = 1L;
      Employee employee = session.get(Employee.class, employeeId);
      System.out.println(employee);
      System.out.println("---------------------");
      Employee employee2 = session.get(Employee.class, employeeId);
      System.out.println(employee2);
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

  private static void sessionCacheForInsertRecord() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Employee employee = new Employee();
      employee.setEmployeeName("Janet Warren");
      employee.setUsername("janetw");
      employee.setPassword("janet#123");
      employee.setAccessLevel(1);

      session.beginTransaction();
      Long employeeId = (Long) session.save(employee);
      session.getTransaction().commit();
      System.out.println("-------------------------------");
      Employee emp = session.get(Employee.class, employeeId);
      System.out.println(emp);
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
