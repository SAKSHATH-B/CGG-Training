package cgg.spring.jdbc.service;

import cgg.spring.jdbc.entities.Employee;

public interface EmployeeService {
  public abstract Employee fetchEmpNameAndSalById(int emp_id);
}
