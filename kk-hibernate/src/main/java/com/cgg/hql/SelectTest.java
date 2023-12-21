package com.cgg.hql;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SelectTest {

  public static void main(String[] args) {
    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();

    //getallemployees
    String getAllEmp = "from Employee";
    Query<Employee> query1 = session.createQuery(getAllEmp, Employee.class);
    query1.list().forEach(System.out::println);

    System.out.println("-------------------------------------");

    //getEmpbyId
    int empId = 2;
    String getEmpbyId = "from Employee where employeeId = :x ";
    Query<Employee> query2 = session.createQuery(getEmpbyId, Employee.class);
    query2.setParameter("x", empId);
    Employee employeebyId = query2.uniqueResult();
    System.out.println(employeebyId);

    System.out.println("------------------------------------------");

    //getEmpbyIdandEmail
    String getEmpbyIdandEmail =
      "from Employee where employeeId=:x and email=:y ";
    Query<Employee> query3 = session.createQuery(
      getEmpbyIdandEmail,
      Employee.class
    );
    query3.setParameter("x", 2);
    query3.setParameter("y", "martin.b2017@gmail.com");
    Employee empbyidandemail = query3.uniqueResult();
    System.out.println(empbyidandemail);

    System.out.println("------------------------------------------");
    //getAllEmpName
    String getAllEmpName = "select employeeName from Employee";
    Query<String> query4 = session.createQuery(getAllEmpName);
    query4.list().forEach(System.out::println);

    System.out.println("------------------------------------------");
    //getAllEmpIdandName
    String getAllEmpIdandName = "select employeeName, employeeId from Employee";
    Query query5 = session.createQuery(getAllEmpIdandName);
    List<Object[]> list = query5.list();
    for (Object[] objects : list) {
      Integer employeeId = (Integer) objects[1];
      String employeeName = (String) objects[0];
      System.out.println(employeeId + " : " + employeeName);
    }

    session.close();
  }
}
