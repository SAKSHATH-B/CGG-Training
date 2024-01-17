package cgg.spring.jdbc.service;

import cgg.spring.jdbc.dao.EmployeeDao;
import cgg.spring.jdbc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDao employeeDao;

  public void setEmployeeDao(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  @Override
  public Employee fetchEmpNameAndSalById(int emp_id) {
    return employeeDao.getEmpNameAndSalById(emp_id);
  }
}
