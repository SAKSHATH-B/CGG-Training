package cgg.spring.jdbc;

import cgg.spring.jdbc.config.JdbcConfig;
import cgg.spring.jdbc.entities.Employee;
import cgg.spring.jdbc.service.EmployeeService;
import cgg.spring.jdbc.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CT {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
      JdbcConfig.class
    );
    EmployeeService employeeService = context.getBean(
      "employeeService",
      EmployeeServiceImpl.class
    );
    Employee employee = employeeService.fetchEmpNameAndSalById(2);
    System.out.println(employee.getEmp_name() + "\t" + employee.getEmp_sal());
  }
}
