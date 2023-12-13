package Employee;

public class EmployeeMapper {

  public EmployeeDo convert(Employee employee) {
    EmployeeDo employeeDO = new EmployeeDo();
    employeeDO.setId(employee.getId());
    employeeDO.setName(employee.getName());
    employee.setSalary(employee.getSalary());
    return employeeDO;
  }
}
