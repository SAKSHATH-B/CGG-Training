package com.cgg.hql;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateandDeleteTest {

  public static void main(String[] args) {
    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();

    //insert into Employee
    int empId = 2;
    // String newEmail = "martin.b2007@gmail.com";
    // String updateEmpEmailbyId =
    //   "update Employee set email=:x where employeeId=:y ";
    // Query query1 = session.createQuery(updateEmpEmailbyId);
    // query1.setParameter("x", newEmail);
    // query1.setParameter("y", empId);

    //delete employeebyId
    String deleteEmpbyId = "delete from Employee where employeeId=:y ";
    Query query2 = session.createQuery(deleteEmpbyId);
    query2.setParameter("y", empId);

    session.beginTransaction();
    // int executeUpdate = query1.executeUpdate();
    int executeUpdate = query2.executeUpdate();
    session.getTransaction().commit();
    // if (executeUpdate > 0) {
    //   System.out.println(executeUpdate + " records modified...");
    // }
    if (executeUpdate > 0) {
      System.out.println(executeUpdate + " records deleted...");
    }

    session.close();
  }
}
