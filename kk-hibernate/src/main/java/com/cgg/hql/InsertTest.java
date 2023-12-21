package com.cgg.hql;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class InsertTest {

  public static void main(String[] args) {
    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();

    //insert into Employee
    String insert =
      "insert into Employee(employeeName,doj,salary,bonus,email,designation)" +
      "select employeeName,doj,salary,bonus,email,designation from Employeeb";
    Query query = session.createQuery(insert);
    session.beginTransaction();
    int executeUpdate = query.executeUpdate();
    if (executeUpdate > 0) {
      System.out.println(executeUpdate + " records inserted successfully...");
    }
    session.getTransaction().commit();

    session.close();
  }
}
