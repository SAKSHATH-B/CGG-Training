package com.cgg.CRUDwithDAOandService;

public interface EmployeeService {
  public abstract void createEmployee(Employee employee);

  public abstract Employee getEmployeebyId(int employeeId);

  public abstract void updateEmployeebyId(int employeeId, Double newSal);

  public abstract void deleteEmployeebyId(int employeeId);
}
