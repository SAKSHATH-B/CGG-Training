package com.cgg.Inheritance.JoinedInheritance;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchDataClientTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Person person = session.get(Person.class, 2);

      if (
        person instanceof Person &&
        !(person instanceof Employee) &&
        !(person instanceof Student)
      ) {
        System.out.println(person);
      } else if ((person instanceof Person) && (person instanceof Employee)) {
        Employee employee = (Employee) person;
        System.out.println(employee);
      } else if ((person instanceof Person) && (person instanceof Student)) {
        Student student = (Student) person;
        System.out.println(student);
      }
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
