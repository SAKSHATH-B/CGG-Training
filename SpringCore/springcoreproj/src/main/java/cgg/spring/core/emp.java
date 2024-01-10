package cgg.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class emp {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "spring.xml"
    );
    Employee emp1 = context.getBean(Employee.class);
    emp1.setEid(1000);
    emp1.setEname("DHFM");
    System.out.println(emp1.getEid() + "\t" + emp1.getEname());
    System.out.println("=========================================");
    Employee emp2 = (Employee) context.getBean("employee");
    System.out.println(emp2.getEid() + "\t" + emp2.getEname());
  }
}
