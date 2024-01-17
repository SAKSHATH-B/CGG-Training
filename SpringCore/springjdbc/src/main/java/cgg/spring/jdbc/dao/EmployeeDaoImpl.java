package cgg.spring.jdbc.dao;

import cgg.spring.jdbc.entities.Employee;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

  @Autowired
  private SimpleJdbcCall simpleJdbcCall;

  public void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall) {
    this.simpleJdbcCall = simpleJdbcCall;
  }

  @Override
  public Employee getEmpNameAndSalById(int emp_id) {
    simpleJdbcCall.withProcedureName("getEmpNameAndSalById");
    MapSqlParameterSource input = new MapSqlParameterSource();
    input.addValue("eid", emp_id);
    Map<String, Object> outMap = simpleJdbcCall.execute(input);
    Employee employee = new Employee();
    employee.setEmp_name((String) outMap.get("ename"));
    employee.setEmp_sal((String) outMap.get("esal"));
    return employee;
  }
}
