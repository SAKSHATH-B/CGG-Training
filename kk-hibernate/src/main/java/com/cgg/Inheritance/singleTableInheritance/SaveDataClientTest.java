package com.cgg.Inheritance.singleTableInheritance;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SaveDataClientTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Person person = new Person();
      person.setName("Sudha Verma");
      person.setGender("Female");

      Employee employee = new Employee();
      employee.setBonus(new BigDecimal("277.389"));
      employee.setDeptName("IT");
      employee.setDoj(new Date());
      employee.setEmail("dipesh.cs@gmail.com");
      employee.setName("Dipesh");
      employee.setSalary(80000.2872);
      employee.setGender("Male");

      Student student = new Student();
      student.setName("Shuruti");
      student.setGender("Female");
      student.setFee(20000.00f);
      student.setSchoolName("DPS");
      student.setSectionName("12th Std");

      session.beginTransaction();
      session.persist(person);
      session.persist(student);
      session.persist(employee);

      session.getTransaction().commit();
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
