package cgg.mockito.learnmockito.services;

import cgg.mockito.learnmockito.dao.EmployeeDao;
import cgg.mockito.learnmockito.dao.EmployeeDaoImpl;
import cgg.mockito.learnmockito.entities.Employee;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDao employeeDao = new EmployeeDaoImpl();

  @Override
  public void createEmployee(Employee employee) {
    employeeDao.createEmployee(employee);
  }

  @Override
  public Employee fetchEmployeeById(Integer employeeId) {
    return employeeDao.getEmployeeById(employeeId);
  }

  @Override
  public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
    employeeDao.updateEmployeeEmailById(newEmail, employeeId);
  }

  @Override
  public void deleteEmployeeById(Integer employeeId) {
    employeeDao.deleteEmployeeById(employeeId);
  }

  @Override
  public List<Employee> fetchAllEmployeesInfo() {
    return employeeDao.getAllEmployeesInfo();
  }
}
