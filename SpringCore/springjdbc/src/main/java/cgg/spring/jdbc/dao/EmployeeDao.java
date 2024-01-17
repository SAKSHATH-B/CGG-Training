package cgg.spring.jdbc.dao;

import cgg.spring.jdbc.entities.Employee;

public interface EmployeeDao {
  public abstract Employee getEmpNameAndSalById(int emp_id);
}
