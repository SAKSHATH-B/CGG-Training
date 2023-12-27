package com.cgg.hql.namednativequeries;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ClientTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      session.beginTransaction();

      Employee employee1 = new Employee();
      employee1.setBonus(new BigDecimal(200));
      employee1.setDesignation("HR Lead");
      employee1.setDoj("15/02/2016");
      employee1.setEmail("hello1@gmail.com");
      employee1.setEmployeeName("hello1");
      employee1.setSalary(200000.00);

      Employee employee2 = new Employee();
      employee2.setBonus(new BigDecimal(200));
      employee2.setDesignation("Junior HR");
      employee2.setDoj("25/03/2016");
      employee2.setEmail("hello2@gmail.com");
      employee2.setEmployeeName("hello3");
      employee2.setSalary(40000.00);

      Department department1 = new Department();
      department1.setDepartmentLocation("Pune");
      department1.setDepartmentName("IT Technology");

      department1.getEmployees().add(employee1);
      department1.getEmployees().add(employee2);

      employee1.setDepartment(department1);
      employee2.setDepartment(department1);

      session.persist(department1);

      Employee employee3 = new Employee();
      employee3.setBonus(new BigDecimal(300));
      employee3.setDesignation("IT Manager");
      employee3.setDoj("15/09/2016");
      employee3.setEmail("kk.cs4446@gmail.com");
      employee3.setEmployeeName("Kishan");
      employee3.setSalary(80000.00);

      Employee employee4 = new Employee();
      employee4.setBonus(new BigDecimal(500));
      employee4.setDesignation("Junior IT Manager");
      employee4.setDoj("20/02/2016");
      employee4.setEmail("john5556@gmail.com");
      employee4.setEmployeeName("John");
      employee4.setSalary(70000.00);

      Employee employee5 = new Employee();
      employee5.setBonus(new BigDecimal(500));
      employee5.setDesignation("Senior IT Manager");
      employee5.setDoj("20/07/2016");
      employee5.setEmail("martin5556@gmail.com");
      employee5.setEmployeeName("Martin");
      employee5.setSalary(80000.00);

      Department department2 = new Department();

      department2.setDepartmentLocation("Mumbai");
      department2.setDepartmentName("IT Management");

      department2.getEmployees().add(employee3);
      department2.getEmployees().add(employee4);
      department2.getEmployees().add(employee5);

      employee3.setDepartment(department2);
      employee4.setDepartment(department2);
      employee5.setDepartment(department2);

      session.persist(department2);

      System.out.println("Created/inserted...");
      session.getTransaction().commit();
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
