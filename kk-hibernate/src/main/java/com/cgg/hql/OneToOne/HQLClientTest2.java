package com.cgg.hql.OneToOne;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLClientTest2 {

  public static void main(String[] args) {
    getEmployeeAndAddressByEmpId();
  }

  private static void getEmployeeAndAddressByEmpId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      String q1 =
        "select emp.employeeName,emp.doj,emp.salary,addr.city,addr.pincode from Employee emp left join emp.address addr where emp.employeeId=:empId ";
      Query<Object[]> query1 = session.createQuery(q1);
      query1.setParameter("empId", 1);
      List<Object[]> list = query1.list();
      for (Object[] objects : list) {
        String employeeName = (String) objects[0];
        Date doj = (Date) objects[1];
        Double sal = (Double) objects[2];
        String city = (String) objects[3];
        Long pincode = (Long) objects[4];
        System.out.println(
          employeeName +
          " : " +
          doj +
          " : " +
          sal +
          " : " +
          city +
          " : " +
          pincode
        );
      }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
