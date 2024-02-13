package cgg.mockito.learnmockito.dao;

import cgg.mockito.learnmockito.entities.Employee;
import java.util.List;

public interface EmployeeDao {
  public abstract void createEmployee(Employee employee);

  public abstract Employee getEmployeeById(Integer employeeId);

  public abstract void updateEmployeeEmailById(
    String newEmail,
    Integer employeeId
  );

  public abstract void deleteEmployeeById(Integer employeeId);

  public abstract List<Employee> getAllEmployeesInfo();
}
