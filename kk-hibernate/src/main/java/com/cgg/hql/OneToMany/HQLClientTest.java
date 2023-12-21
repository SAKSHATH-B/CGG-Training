package com.cgg.hql.OneToMany;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLClientTest {

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
      //all column of employees and addresses
      // String HQL = "from Employee where employeeId=:empId";
      // Query<Employee> query = session.createQuery(HQL, Employee.class);
      // Employee employee = query.setParameter("empId", 1).uniqueResult();
      // System.out.println(employee);
      // if (employee != null) {
      //   employee.getAddressList().forEach(System.out::println);
      // }

      //some columns retreiving
      String HQL =
        "select emp.employeeName, emp.salary,addr.city,addr.pincode from Employee emp left join emp.addressList addr where emp.employeeId=:empId";
      List<Object[]> list = session
        .createQuery(HQL)
        .setParameter("empId", 1)
        .list();
      for (Object[] objects : list) {
        String employeeName = (String) objects[0];
        Double sal = (Double) objects[1];
        String city = (String) objects[2];
        Long pincode = (Long) objects[3];
        System.out.println(
          employeeName + " : " + sal + " : " + city + " : " + pincode
        );
      }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
