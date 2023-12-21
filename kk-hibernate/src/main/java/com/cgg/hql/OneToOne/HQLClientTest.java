package com.cgg.hql.OneToOne;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLClientTest {

  public static void main(String[] args) {
    // getEmployeeAndAddressByEmpId();
    getEmployeeAndAddressByAddressId();
  }

  private static void getEmployeeAndAddressByAddressId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      String q2 =
        "from Address addr left join fetch addr.employee where addr.addressId=:addrId";
      Address address = session
        .createQuery(q2, Address.class)
        .setParameter("addrId", 1)
        .uniqueResult();
      System.out.println(address);
      System.out.println(address.getEmployee());
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void getEmployeeAndAddressByEmpId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      String q1 =
        "from Employee emp left join fetch emp.address where emp.employeeId=:empId ";
      Query<Employee> query1 = session.createQuery(q1, Employee.class);
      query1.setParameter("empId", 1);
      Employee employee = query1.uniqueResult();
      System.out.println(employee);
      Address address = employee.getAddress();
      System.out.println(address);
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
