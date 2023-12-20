package com.cgg.CRUDwithDAOandService;

public class EmployeeServiceImpl implements EmployeeService {

  @Override
  public void createEmployee(Employee employee) {
    new EmployeeDAOImpl().addEmployee(employee);
  }

  @Override
  public Employee getEmployeebyId(int employeeId) {
    return new EmployeeDAOImpl().fetchEmployeebyId(employeeId);
  }

  @Override
  public void updateEmployeebyId(int employeeId, Double newSal) {
    new EmployeeDAOImpl().updateEmployee(employeeId, newSal);
  }

  @Override
  public void deleteEmployeebyId(int employeeId) {
    new EmployeeDAOImpl().deleteEmployeebyId(employeeId);
  }
}
