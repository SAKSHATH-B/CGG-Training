package cgg.mockito.learnmockito.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import cgg.mockito.learnmockito.entities.Employee;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = { MockitoExtension.class })
@TestInstance(value = Lifecycle.PER_CLASS)
public class EmployeeServiceTest2 {

  @Mock
  private EmployeeService employeeService;

  /*
   * @BeforeAll public void setUp() {
   *  MockitoAnnotations.openMocks(this);
   *  }
   */

  @Test
  public void testFetchEmployeeById() {
    Employee employee = getEmployee();
    when(employeeService.fetchEmployeeById(10)).thenReturn(employee);

    assertEquals("KK", employeeService.fetchEmployeeById(10).getEmployeeName());
    assertEquals(50000.00, employeeService.fetchEmployeeById(10).getSalary());

    assertAll(
      "testFetchEmployeeById",
      () ->
        assertEquals(
          "KK",
          employeeService.fetchEmployeeById(10).getEmployeeName()
        ),
      () ->
        assertEquals(
          50000.00,
          employeeService.fetchEmployeeById(10).getSalary()
        ),
      () ->
        assertEquals(
          "kk.cs2016@yahoo.com",
          employeeService.fetchEmployeeById(10).getEmail()
        )
    );
  }

  private Employee getEmployee() {
    Employee employee = new Employee();
    employee.setEmployee_id(10);
    employee.setBonus(new BigDecimal(600));
    employee.setDoj(new Date());
    employee.setEmployeeName("KK");
    employee.setEmail("kk.cs2016@yahoo.com");
    employee.setSalary(50000.00);
    return employee;
  }
}
