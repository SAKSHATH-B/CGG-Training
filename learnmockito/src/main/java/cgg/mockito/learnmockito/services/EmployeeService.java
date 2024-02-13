package cgg.mockito.learnmockito.services;

import cgg.mockito.learnmockito.entities.Employee;
import java.util.List;

public interface EmployeeService {
  public abstract void createEmployee(Employee employee);

  public abstract Employee fetchEmployeeById(Integer employeeId);

  public abstract void updateEmployeeEmailById(
    String newEmail,
    Integer employeeId
  );

  public abstract void deleteEmployeeById(Integer employeeId);

  public abstract List<Employee> fetchAllEmployeesInfo();
}
