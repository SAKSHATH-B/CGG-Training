package cgg.springboot.SpringBootProj.controller;

import cgg.springboot.SpringBootProj.entities.Department;
import cgg.springboot.SpringBootProj.entities.Employee;
import cgg.springboot.SpringBootProj.entities.Phone;
import java.util.List;
import org.hibernate.SessionFactory;

public class JPAJoinTypes {

  SessionFactory sessionFactory;

  public void implicitInnerJoin() {
    List list1 = sessionFactory
      .getCurrentSession()
      .createQuery("Select * from employee", Employee.class)
      .list();
    List list2 = sessionFactory
      .getCurrentSession()
      .createQuery("Select * from employee", Phone.class)
      .list();
    List list3 = sessionFactory
      .getCurrentSession()
      .createQuery("Select * from employee", Department.class)
      .list();
  }
}
