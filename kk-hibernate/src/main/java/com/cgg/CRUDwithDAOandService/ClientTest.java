package com.cgg.CRUDwithDAOandService;

import java.util.Date;

public class ClientTest {

  public static void main(String[] args) {
    EmployeeService employeeService = new EmployeeServiceImpl();
    // createEmployee(employeeService);
    // getEmployeebyId(employeeService);
    // updateEmployeebyId(employeeService);
    deleteEmployeebyId(employeeService);
  }

  private static void createEmployee(EmployeeService employeeService) {
    employeeService.createEmployee(getEmployee());
  }

  private static void getEmployeebyId(EmployeeService employeeService) {
    Employee employee = employeeService.getEmployeebyId(1);
    System.out.println(employee);
  }

  private static void updateEmployeebyId(EmployeeService employeeService) {
    employeeService.updateEmployeebyId(1, 10000.00);
  }

  private static void deleteEmployeebyId(EmployeeService employeeService) {
    employeeService.deleteEmployeebyId(1);
  }

  private static Employee getEmployee() {
    Employee employee = new Employee();
    employee.setEmployeeName("luther king");
    employee.setEmail("lk@gmail.com");
    employee.setSalary(60000.00);
    employee.setDoj(new Date());
    return employee;
  }
}
