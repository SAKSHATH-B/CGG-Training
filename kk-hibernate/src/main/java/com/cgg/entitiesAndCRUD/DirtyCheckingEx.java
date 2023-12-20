package com.cgg.entitiesAndCRUD;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DirtyCheckingEx {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      updateEmployee(session);
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

  private static void updateEmployee(Session session) {
    Employee employee = session.get(Employee.class, 1);
    if (employee != null) {
      session.beginTransaction();
      employee.setSalary(50000);

      //if we are changing the state of the object within the transaction boundary and also not calling the update method which also updates the value to db is called dirtyChecking method
      //   session.update(employee);
      session.getTransaction().commit();
      employee.setEmployeeName("luther ford"); //These changes are ignored because it is not committed
    } else {
      System.out.println("Employee doesnt exist with provided ID...");
    }
  }
}
