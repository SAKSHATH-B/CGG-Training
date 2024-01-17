package cgg.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class emp {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("empl.xml");
    // Employee emp1 = context.getBean(Employee.class);
    // emp1.setEid(1000);
    // emp1.setEname("DHFM");
    // System.out.println(emp1.getEid() + "\t" + emp1.getEname());
    // System.out.println("=========================================");
    // Employee emp2 = (Employee) context.getBean(Employee.class);
    // System.out.println(emp2.getEid() + "\t" + emp2.getEname());

    // Employee emp = context.getBean(Employee.class);
    // System.out.println(emp.getEid() + "\t" + emp.getEname());

    Employee empl = context.getBean("employee", Employee.class);
    System.out.println(
      empl.getEid() + "\t" + empl.getEname() + "\t" + empl.getAddress()
    );
  }
}
