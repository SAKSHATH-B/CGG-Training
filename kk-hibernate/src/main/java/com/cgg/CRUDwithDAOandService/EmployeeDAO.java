package com.cgg.CRUDwithDAOandService;

public interface EmployeeDAO {
  public abstract void addEmployee(Employee employee);

  public abstract Employee fetchEmployeebyId(int employeeId);

  public abstract void updateEmployee(int employeeId, Double newSal);

  public abstract void deleteEmployeebyId(int employeeId);
}
