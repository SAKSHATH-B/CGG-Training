package cgg.mockito.learnmockito;

import cgg.mockito.learnmockito.entities.Employee;
import cgg.mockito.learnmockito.services.EmployeeService;
import cgg.mockito.learnmockito.services.EmployeeServiceImpl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnmockitoApplication {

  public static void main(String[] args) {
    // SpringApplication.run(LearnmockitoApplication.class, args);
    EmployeeService employeeService = new EmployeeServiceImpl();

    Employee employee = getEmployee();
    // employeeService.createEmployee(employee);
    // getEmployeeById(employeeService);
    // employeeService.updateEmployeeEmailById("sean.cs2020@gmail.com", 3);
    // employeeService.deleteEmployeeById(4);
    getAllEmployeesInfo(employeeService);
  }

  private static Employee getEmployee() {
    Employee employee = new Employee();
    employee.setBonus(new BigDecimal(600));
    employee.setDoj(new Date());
    employee.setEmployeeName("KK");
    employee.setEmail("kk.cs2016@yahoo.com");
    employee.setSalary(50000.00);
    return employee;
  }

  private static void getAllEmployeesInfo(EmployeeService employeeService) {
    List<Employee> empList = employeeService.fetchAllEmployeesInfo();
    for (Employee employee : empList) {
      System.out.println(employee);
    }
  }

  private static void getEmployeeById(EmployeeService employeeService) {
    Employee employee2 = employeeService.fetchEmployeeById(1);
    if (employee2 != null) {
      System.out.println(employee2);
    } else {
      System.out.println("Employee does not exist..");
    }
  }
}
