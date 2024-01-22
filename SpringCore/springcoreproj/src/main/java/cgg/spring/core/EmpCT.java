package cgg.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpCT {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("empl.xml");
    Employee employee = context.getBean("employee", Employee.class);

    if (employee != null) {
      System.out.println(employee.getEid() + "\t" + employee.getEname());
      Pancard pancard = employee.getPancard();
      if (pancard != null) {
        System.out.println(pancard);
      }
    }

    ((AbstractApplicationContext) context).close();
  }
}
